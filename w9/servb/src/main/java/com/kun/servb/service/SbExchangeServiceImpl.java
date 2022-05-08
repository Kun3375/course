package com.kun.servb.service;

import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import com.kun.serva.api.ExchangeParam;
import com.kun.serva.api.ExchangeResult;
import com.kun.serva.api.service.SaExchangeService;
import com.kun.servb.mapper.AccountMapper;
import com.kun.servb.mapper.BizOrderMapper;
import com.kun.servb.model.Account;
import com.kun.servb.model.BizOrder;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author kun
 * @date 2022/5/8
 */
@Service
public class SbExchangeServiceImpl implements SbExchangeService {

    private final Logger log = LoggerFactory.getLogger(SbExchangeServiceImpl.class);

    @DubboReference
    private SaExchangeService saExchangeService;

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private BizOrderMapper bizOrderMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void exchange() {
        Long userId = 222L;
        String ccyBuy = "CNY";
        String ccySell = "USD";
        BigDecimal amountBuy = new BigDecimal("7");
        BigDecimal amountSell = new BigDecimal("1");
        BizOrder order = new BizOrder();
        order.setUserId(userId);
        order.setOpSys("serva");
        order.setOpUserId(null);
        order.setOpOrderId(null);
        order.setCurrencyBuy(ccyBuy);
        order.setAmountBuy(amountBuy);
        order.setCurrencySell(ccySell);
        order.setAmountSell(amountSell);
        bizOrderMapper.insert(order);
        log.info("order init");

        Account buy = ChainWrappers.lambdaQueryChain(accountMapper)
                .eq(Account::getUserId, userId)
                .eq(Account::getCurrency, ccyBuy)
                .one();
        Account sell = ChainWrappers.lambdaQueryChain(accountMapper)
                .eq(Account::getUserId, userId)
                .eq(Account::getCurrency, ccySell)
                .one();
        if (buy == null || sell == null ||
                sell.getBalance().compareTo(amountSell) < 0) {
            throw new RuntimeException("cant exchange");
        }

        // rpc exchange
        ExchangeParam param = new ExchangeParam();
        param.setReqSys("servb");
        param.setReqUserId(userId);
        param.setReqOrderId(order.getId());
        param.setCurrencyBuy(ccyBuy);
        param.setAmountBuy(amountBuy);
        param.setCurrencySell(ccySell);
        param.setAmountSell(amountSell);
        ExchangeResult r = saExchangeService.exchange(param);

        order.setOpOrderId(r.getRespOrderId());
        order.setOpUserId(r.getRespUserId());
        bizOrderMapper.updateById(order);

        int i = accountMapper.balanceAdd(buy.getId(), amountBuy);
        int j = accountMapper.balanceDeduct(sell.getId(), amountSell);
        if (i == 0 || j == 0) {
            throw new RuntimeException("cant exchange");
        }
    }
}
