package com.kun.order.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.function.Consumer;

/**
 * @author kun
 * @date 2022/5/22
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PubSub {

    private static final String PUB_PREFIX = "demo:order";
    private final StringRedisTemplate stringRedisTemplate;
    private final RedisMessageListenerContainer container;
    private final ObjectMapper objectMapper;

    /**
     * just demo
     */
    @Setter
    private Consumer<OrderReq> process;

    @PostConstruct
    private void init() {
        container.addMessageListener((Message message, @Nullable byte[] pattern) -> {
            // 使用一致的序列化器
            String msgStr = stringRedisTemplate.getStringSerializer().deserialize(message.getBody());
            if (msgStr == null) {
                return;
            }
            OrderReq orderReq;
            try {
                orderReq = objectMapper.readValue(msgStr, OrderReq.class);
            } catch (JsonProcessingException ignored) {
                return;
            }
            if (process == null) {
                return;
            }
            process.accept(orderReq);
        }, new PatternTopic(PUB_PREFIX));
    }

    /**
     * 发布广播
     * 并不适合订单场景
     */
    @SneakyThrows(JsonProcessingException.class)
    public void publishOrder(OrderReq msg) {
        stringRedisTemplate.convertAndSend(PUB_PREFIX, objectMapper.writeValueAsString(msg));
    }

    @Data
    public static class OrderReq {
        private Long id;
        private BigDecimal amount;
    }


}
