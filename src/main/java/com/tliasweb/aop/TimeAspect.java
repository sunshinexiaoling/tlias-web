package com.tliasweb.aop;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author ling
 * @desc:
 * @date 2024/3/19 23:26
 */
@Component
@Aspect
@Slf4j
public class TimeAspect {
    @Around("execution(* com.tliasweb.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end=System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature()+"方法消耗的时间为：{}ms",(end-begin));
        return result;
    }
}
