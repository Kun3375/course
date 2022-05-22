package com.kun.order.redis;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author kun
 * @date 2022/5/22
 */
@Component
@RequiredArgsConstructor
public class RedisLock {

    private static final Duration DEFAULT_LOCK_TIME = Duration.ofSeconds(30);
    private final StringRedisTemplate stringRedisTemplate;
    private final RedisScript<Boolean> unlockScript;

    /**
     * 上锁
     * 不处理续租，超时手动回滚
     *
     */
    public LockUnit lock(String key, Long time, TimeUnit timeUnit) {
        String value = UUID.randomUUID().toString();
        Boolean suc;
        if (time == null) {
            suc = stringRedisTemplate.opsForValue().setIfAbsent(key, value, DEFAULT_LOCK_TIME);
        } else {
            suc = stringRedisTemplate.opsForValue().setIfAbsent(key, value, time, timeUnit);
        }
        return suc != null && suc ? new LockUnit(key, value) : null;
    }

    /**
     * 解锁
     */
    public boolean unlock(LockUnit unit) {
        Boolean suc = stringRedisTemplate.execute(unlockScript, Arrays.asList(unit.key, unit.value));
        return suc != null && suc;
    }

    @Getter
    @RequiredArgsConstructor
    public static class LockUnit {
        private final String key;
        private final String value;
    }
}
