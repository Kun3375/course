package com.kun.order.redis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kun
 * @date 2022/5/22
 */
@SpringBootTest
class RedisLockTest {

    @Autowired
    private RedisLock redisLock;

    @ParameterizedTest
    @CsvSource({"test1, 10", "test2, "})
    void testLock(String key, Long time) {
        RedisLock.LockUnit lock = redisLock.lock(key, time, TimeUnit.SECONDS);
        assertNotNull(lock);
        assertAll(
                () -> assertEquals(key, lock.getKey()),
                () -> assertNotNull(lock.getValue())
        );
    }

    @Test
    void testUnlock() {
        RedisLock.LockUnit lockUnit = redisLock.lock("testUnlock", 30L, TimeUnit.SECONDS);
        boolean suc = redisLock.unlock(lockUnit);
        assertTrue(suc);
    }
}
