package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class DemoLoggingAspect {
    private Logger myLogger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
    private void forAppFlow() {}


    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        myLogger.info("====>in @Before: calling method: "+ theJoinPoint.getSignature().toShortString());
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theRs"
    )
    public void afterReturing(JoinPoint theJoinPoint, Object theRs) {
        myLogger.info("====>in @Before: calling method: "+ theJoinPoint.getSignature().toShortString());

        myLogger.info("===>result: "+ theRs);
    }
}
