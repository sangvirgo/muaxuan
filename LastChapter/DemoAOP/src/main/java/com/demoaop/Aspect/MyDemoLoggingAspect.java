package com.demoaop.Aspect;

import com.demoaop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

}



// mung hai vui ve
// yeu doi


//mung ba vui ve
// vui ve iu doi