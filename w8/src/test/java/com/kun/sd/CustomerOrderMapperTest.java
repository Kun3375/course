package com.kun.sd;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kun.sd.CustomerOrder;
import com.kun.sd.OrderMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author kun
 * @date 2022/4/24
 */
@SpringBootTest
class CustomerOrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    private Long orderId = 1518239560243367940L;

    @Test
    @Order(0)
    void testInsert() {
        CustomerOrder order = new CustomerOrder();
        order.setId(orderId);
        order.setCustomerId(123L);
        order.setTotalPrice(new BigDecimal("100.2"));
        order.setActualPrice(new BigDecimal("90.1"));
        int insert = orderMapper.insert(order);
        Assertions.assertTrue(insert > 0);
    }

    @Test
    @Order(1)
    void testSelect() {
        List<CustomerOrder> list = orderMapper.selectList(Wrappers.emptyWrapper());
        Assertions.assertNotNull(list);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    @Order(2)
    void testUpdate() {
        CustomerOrder order = new CustomerOrder();
        order.setId(orderId);
        // cant update shading key
        order.setTotalPrice(new BigDecimal("100.2"));
        order.setActualPrice(new BigDecimal("55.1"));
        orderMapper.updateById(order);
    }

    @Test
    @Order(3)
    void testDelete() {
        orderMapper.deleteById(orderId);
    }
}
