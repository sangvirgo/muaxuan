package com.demoaop.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogging {
    @Before("com.demoaop.Aspect.AOPExpression.forDaoPackageNoSetterNoGetter()")
    public void logToCloud() {
        System.out.println("\n==============> Logging to cloud ");
    }
}
