package com.kun.servb;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kun
 * @date 2022/5/8
 */
@EnableDubbo
@SpringBootApplication
public class SbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbApplication.class, args);
    }


}
