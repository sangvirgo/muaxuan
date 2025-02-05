package com.demoaop.Aspect;


import com.demoaop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiPerforming {
    @Before("com.demoaop.Aspect.AOPExpression.forDaoPackageNoSetterNoGetter()")
    public void performAPI(JoinPoint theJoinPoint) {
        System.out.println("==============> Performing API ");

        MethodSignature methodSignature= (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args=theJoinPoint.getArgs();

        for (Object temp: args) {
            System.out.println(temp);

            if(temp instanceof Account) {
                Account theTemp=(Account) temp;

                System.out.println("Account name: " + theTemp.getName());
                System.out.println("Account level: " + theTemp.getLevel());
            }
        }
    }
}
