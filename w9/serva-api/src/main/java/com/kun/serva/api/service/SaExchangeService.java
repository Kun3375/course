package com.kun.serva.api.service;

import com.kun.serva.api.ExchangeParam;
import com.kun.serva.api.ExchangeResult;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kun
 * @date 2022/5/8
 */
public interface SaExchangeService {

    @Hmily
    @Transactional(rollbackFor = RuntimeException.class)
    ExchangeResult exchange(ExchangeParam param);

}
