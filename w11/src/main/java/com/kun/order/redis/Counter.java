package com.kun.order.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author kun
 * @date 2022/5/22
 */
@Component
@RequiredArgsConstructor
public class Counter {

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * demo 没啥好封装的
     */
    public Long incre(String key, Long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }
}
