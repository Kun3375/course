package com.kun.atomikos;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author kun
 * @date 2022/4/24
 */
@Data
@TableName("t_order")
public class CustomerOrder {

    @TableId(type = IdType.INPUT)
    private Long id;

    private Long customerId;

    private BigDecimal totalPrice;

    private BigDecimal actualPrice;

//    private String remark;

    private Date payTime;

    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Date createTime;

    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Date updateTime;
}
