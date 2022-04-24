package com.kun.atomikos;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kun
 * @date 2022/4/24
 */
@Slf4j
@Service
public class XADemoServiceImpl implements IService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    @ShardingTransactionType(TransactionType.XA)
    public void saveOrder(CustomerOrder order, CustomerOrder order2) {
        orderMapper.insert(order);
        log.info("saved: {}", order);
        // 使用不同库的订单测试
        orderMapper.insert(order2);
        log.info("saved: {}", order2);
    }
}
