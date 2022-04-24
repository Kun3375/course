package com.kun.atomikos;

import com.kun.atomikos.CustomerOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author kun
 * @date 2022/4/24
 */
@SpringBootTest
public class XATest {

    @Autowired
    private IService service;

    @Test
    void testInsert() {
        CustomerOrder order = new CustomerOrder();
        order.setId(12345990L);
        order.setCustomerId(123L);
        order.setTotalPrice(new BigDecimal("100.2"));
        order.setActualPrice(new BigDecimal("90.1"));

        CustomerOrder order2 = new CustomerOrder();
        order2.setId(12346991L);
        order2.setCustomerId(123L);
        order2.setTotalPrice(new BigDecimal("123.2"));
        order2.setActualPrice(new BigDecimal("55.1"));
        service.saveOrder(order, order2);
    }
}
