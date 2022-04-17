package com.kun.ards;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author kun
 * @date 2022/4/17
 */
@Slf4j
@Aspect
@Component
public class DataSourceAspect {

    @Around(value = "@annotation(dataSource)", argNames = "pjp, dataSource")
    public Object around(ProceedingJoinPoint pjp, DataSource dataSource) throws Throwable {
        String value = dataSource.value();
        if (value == null || value.isEmpty()) {
            return pjp.proceed();
        }
        CustomDataSource.DS.set(value);
        log.info("datasource {} chosen", value);
        try {
            return pjp.proceed();
        } finally {
            CustomDataSource.DS.remove();
        }
    }
}
