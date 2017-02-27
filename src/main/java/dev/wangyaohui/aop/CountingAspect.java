package dev.wangyaohui.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by wangyaohui on 2017/2/27.
 */
@Aspect
@Component
public class CountingAspect {

    @Pointcut("@annotation(dev.wangyaohui.tools.Counting)")
    public void annotationPointCut() {
    }

    @Around("annotationPointCut()")
    public void around(ProceedingJoinPoint joinPoint) {
        Long startTime = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
