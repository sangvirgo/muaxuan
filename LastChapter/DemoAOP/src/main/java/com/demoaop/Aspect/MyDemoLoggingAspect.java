package com.demoaop.Aspect;

import com.demoaop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerJwtAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
//    @Before("execution(public void com.demoaop.DAO.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.demoaop.entity.Account, ..))")
//    @Before("execution(* com.demoaop..add*(..))")
    @Before("com.demoaop.Aspect.AOPExpression.forDaoPackageNoSetterNoGetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("==========>>>>> Executing @Before advice on addAccount");
    }


    @AfterReturning(
            pointcut = "execution(* com.demoaop.DAO.AccountDAO.findAccount(..))",
            returning = "rs"
    )
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> rs) {
        String method=theJoinPoint.getSignature().toShortString();

        System.out.println("\n==========> Executing @AfterReturning on method: "+ method);

        System.out.println("\n==========>Result is: "+ rs);

        convertAccountNameToUpperCase(rs);

        System.out.println("\n==========>Result after modify is: "+ rs);
    }

    private void convertAccountNameToUpperCase(List<Account> rs) {

        for (Account temp: rs) {
            String t=temp.getName().toUpperCase();
            temp.setName(t);
        }
    }


    @AfterThrowing(
            pointcut = "execution(* com.demoaop.DAO.AccountDAO.findAccount(..))",
            throwing = "throwable"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable throwable) {
        String method=joinPoint.getSignature().toShortString();

        System.out.println("\n==========> Executing @AfterReturning on method: "+ method);

        System.out.println("\n==========>Result is: "+ throwable);
    }




    @After("execution(* com.demoaop.DAO.AccountDAO.findAccount(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method=theJoinPoint.getSignature().toShortString();

        System.out.println("\n==========> Executing @After Finally on method: "+ method);
    }


    @Around("execution(* com.demoaop.service.TrafficService.getFortune(..))")
    public Object aroundGetForture(
            ProceedingJoinPoint theProceedingJoinPoint
    ) throws Throwable {
        String method=theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n----Around---- Executing @Around on method: "+ method);

        long begin =System.currentTimeMillis();

        Object rs=null;

        try {
            rs=theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e.getMessage());

            rs="Have bug!!!!!!!!!!";
        }

        long end= System.currentTimeMillis();

        long duration=end-begin;

        System.out.println("----Around----Duration: "+ duration/1000.0 + " second\n");

        return rs;
    }
}



// mung hai vui ve
// yeu doi


//mung ba vui ve
// vui ve iu doi