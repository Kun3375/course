package com.kun.order.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

/**
 * @author kun
 * @date 2022/5/22
 */
@Configuration
public class RedisLockConfig {

    private static final String UNLOCK = "" +
            "if redis.call('get', KEYS[1]) == KEYS[2] then " +
            "    return redis.call('del', KEYS[1]) " +
            "else " +
            "    return 0 " +
            "end ";

    @Bean
    public RedisScript<Boolean> unlockScript() {
        DefaultRedisScript<Boolean> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setResultType(Boolean.class);
        defaultRedisScript.setScriptText(UNLOCK);
        return defaultRedisScript;
    }
}
