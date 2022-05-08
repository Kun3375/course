package com.kun.serva.api;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author kun
 * @date 2022/5/8
 */
@Data
public class ExchangeParam {

    private String reqSys;

    private Long reqOrderId;

    private Long reqUserId;

    private String currencySell;

    private BigDecimal amountSell;

    private String currencyBuy;

    private BigDecimal amountBuy;
}
