package com.demoaop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void com.demoaop.DAO.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.demoaop.entity.Account, ..))")
    @Before("execution(* com.demoaop..add*(..))")
    public void beforeAddAccountAdvice() {
        
        System.out.println("\n ==========>>>>> Executing @Before advice on addAccount");

    }
}



// mung hai vui ve
// yeu doi


//mung ba vui ve
// vui ve iu doi