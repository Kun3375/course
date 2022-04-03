package com.kun.p1.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author kun
 * @date 2022/4/3
 */
public class PointDemo {

    public void around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("before doing");
        try {
            pjp.proceed();
        } finally {
            System.out.println("after returning or throwing");
        }
    }
}
