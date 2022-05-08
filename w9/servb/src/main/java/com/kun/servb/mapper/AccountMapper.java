package com.kun.servb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kun.servb.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * @author kun
 * @date 2022/5/8
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    @Update("update account set balance = balance - #{amount}, frozen = frozen + #{amount} " +
            "where id = #{id} and balance >= #{amount}")
    int deductFreeze(@Param("id") Long id, @Param("amount")BigDecimal amount);

    @Update("update account set frozen = frozen + #{amount} where id = #{id}")
    int frozenAdd(@Param("id") Long id, @Param("amount") BigDecimal amount);

    @Update("update account set frozen = frozen - #{amount} where id = #{id}")
    int frozenDeduct(@Param("id") Long id, @Param("amount") BigDecimal amount);

    @Update("update account set balance = balance + #{amount} where id = #{id}")
    int balanceAdd(@Param("id") Long id, @Param("amount") BigDecimal amount);

    @Update("update account set balance = balance - #{amount} where id = #{id} and balance >= #{balance}")
    int balanceDeduct(@Param("id") Long id, @Param("amount") BigDecimal amount);

    @Update("update account set balance = balance + #{amount}, frozen = frozen - #{amount} " +
            "where id = #{id} and frozen >= #{amount}")
    int unfreeze(@Param("id") Long id, @Param("amount") BigDecimal amount);
}
