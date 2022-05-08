package com.kun.serva.service;

import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import com.kun.serva.api.ExchangeParam;
import com.kun.serva.api.ExchangeResult;
import com.kun.serva.api.ex.CantExchangeException;
import com.kun.serva.api.service.SaExchangeService;
import com.kun.serva.mapper.AccountMapper;
import com.kun.serva.mapper.BizOrderMapper;
import com.kun.serva.model.Account;
import com.kun.serva.model.BizOrder;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kun
 * @date 2022/5/8
 */
@Service
@DubboService
public class SaExchangeServiceImpl implements SaExchangeService {

    private final Logger log = LoggerFactory.getLogger(SaExchangeServiceImpl.class);

    @Autowired
    private BizOrderMapper bizOrderMapper;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    @HmilyTCC(confirmMethod = "exchangeConfirm", cancelMethod = "exchangeCancel")
    @Transactional(rollbackFor = RuntimeException.class)
    public ExchangeResult exchange(ExchangeParam param) {
        // assuming that only one user matched to exchange
        Long userId = 111L;
        Account buy = ChainWrappers.lambdaQueryChain(accountMapper)
                .eq(Account::getUserId, userId)
                .eq(Account::getCurrency, param.getCurrencyBuy())
                .one();
        Account sell = ChainWrappers.lambdaQueryChain(accountMapper)
                .eq(Account::getUserId, userId)
                .eq(Account::getCurrency, param.getCurrencySell())
                .one();
        if (buy == null || sell == null ||
                buy.getBalance().compareTo(param.getAmountBuy()) < 0) {
            throw new CantExchangeException("cant match exchange");
        }

        int i = accountMapper.deductFreeze(buy.getId(), param.getAmountBuy());
        int j = accountMapper.frozenAdd(sell.getId(), param.getAmountSell());
        if (i == 0 && j == 0) {
            throw new CantExchangeException("cant match exchange");
        }
        BizOrder order = new BizOrder();
        order.setUserId(userId);
        order.setOpSys(param.getReqSys());
        order.setOpUserId(param.getReqUserId());
        order.setOpOrderId(param.getReqOrderId());
        order.setCurrencyBuy(param.getCurrencyBuy());
        order.setAmountBuy(param.getAmountBuy());
        order.setCurrencySell(param.getCurrencySell());
        order.setAmountSell(param.getAmountSell());
        bizOrderMapper.insert(order);
        log.info("order {} try done", param.getReqOrderId());

        ExchangeResult result = new ExchangeResult();
        result.setRespUserId(userId);
        result.setRespOrderId(order.getId());
        return result;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void exchangeConfirm(ExchangeParam param) {
        BizOrder order = ChainWrappers.lambdaQueryChain(bizOrderMapper)
                .eq(BizOrder::getOpOrderId, param.getReqOrderId())
                .one();
        Long userId = order.getUserId();

        Account buy = ChainWrappers.lambdaQueryChain(accountMapper)
                .eq(Account::getUserId, userId)
                .eq(Account::getCurrency, param.getCurrencyBuy())
                .one();
        Account sell = ChainWrappers.lambdaQueryChain(accountMapper)
                .eq(Account::getUserId, userId)
                .eq(Account::getCurrency, param.getCurrencySell())
                .one();

        accountMapper.frozenDeduct(buy.getId(), param.getAmountBuy());
        accountMapper.unfreeze(sell.getId(), param.getAmountSell());
        log.info("order {} confirmed", param.getReqOrderId());
    }

    public void exchangeCancel(ExchangeParam param) {
        BizOrder order = ChainWrappers.lambdaQueryChain(bizOrderMapper)
                .eq(BizOrder::getOpOrderId, param.getReqOrderId())
                .one();
        Long userId = order.getUserId();

        Account buy = ChainWrappers.lambdaQueryChain(accountMapper)
                .eq(Account::getUserId, userId)
                .eq(Account::getCurrency, param.getCurrencyBuy())
                .one();
        Account sell = ChainWrappers.lambdaQueryChain(accountMapper)
                .eq(Account::getUserId, userId)
                .eq(Account::getCurrency, param.getCurrencySell())
                .one();

        accountMapper.unfreeze(buy.getId(), param.getAmountBuy());
        accountMapper.frozenDeduct(sell.getId(), param.getAmountSell());
        log.info("order {} cancelled", param.getReqOrderId());
    }
}
