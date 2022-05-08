package com.kun.serva;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kun
 * @date 2022/5/8
 */
@EnableDubbo
@SpringBootApplication
public class SaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaApplication.class, args);
    }


}
