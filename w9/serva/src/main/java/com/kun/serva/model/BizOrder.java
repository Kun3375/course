package com.kun.serva.model;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author kun
 * @date 2022/5/8
 */
@Data
public class BizOrder {

    private Long id;

    private Long userId;

    private String opSys;

    private Long opUserId;

    private Long opOrderId;

    private String currencyBuy;

    private BigDecimal amountBuy;

    private String currencySell;

    private BigDecimal amountSell;

    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createTime;

    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime updateTime;
}
