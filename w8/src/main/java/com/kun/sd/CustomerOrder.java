package com.kun.sd;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    @TableId
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
