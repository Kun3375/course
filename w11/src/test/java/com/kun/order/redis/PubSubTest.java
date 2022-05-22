package com.kun.order.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author kun
 * @date 2022/5/22
 */
@SpringBootTest
class PubSubTest {

    @Autowired
    private PubSub pubSub;

    @Test
    void testPub() {
        PubSub.OrderReq req = new PubSub.OrderReq();
        req.setAmount(new BigDecimal("13.2"));
        req.setId(13L);
        Assertions.assertDoesNotThrow(() -> pubSub.publishOrder(req));
    }

    @Test
    void testSub() throws InterruptedException {

        AtomicReference<PubSub.OrderReq> receiver = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);

        pubSub.setProcess(req -> {
            receiver.set(req);
            latch.countDown();
        });

        Long id = 13L;
        PubSub.OrderReq req = new PubSub.OrderReq();
        req.setAmount(new BigDecimal("13.2"));
        req.setId(id);
        Assertions.assertDoesNotThrow(() -> pubSub.publishOrder(req));

        boolean suc = latch.await(3, TimeUnit.SECONDS);
        Assertions.assertTrue(suc, "timeout no result");
        Assertions.assertEquals(id, receiver.get().getId());
    }
}
