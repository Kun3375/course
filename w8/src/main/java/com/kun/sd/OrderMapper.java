package com.kun.sd;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kun
 * @date 2022/4/24
 */
@Mapper
public interface OrderMapper extends BaseMapper<CustomerOrder> {
}
