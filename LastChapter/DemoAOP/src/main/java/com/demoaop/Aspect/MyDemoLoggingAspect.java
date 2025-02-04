package com.demoaop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.demoaop.DAO.*.*(..)))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.demoaop.DAO.*.get*(..))")
    private void forGetter() {}

    @Pointcut("execution(* com.demoaop.DAO.*.set*(..))")
    private void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter() )")
    private void forDaoPackageNoSetterNoGetter() {}


//    @Before("execution(public void com.demoaop.DAO.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.demoaop.entity.Account, ..))")
//    @Before("execution(* com.demoaop..add*(..))")
    @Before("forDaoPackageNoSetterNoGetter()")
    public void beforeAddAccountAdvice() {
        
        System.out.println("\n ==========>>>>> Executing @Before advice on addAccount");

    }

    @Before("forDaoPackageNoSetterNoGetter()")
    public void performAPI() {
        System.out.println("==============> Performing API ");
    }
}



// mung hai vui ve
// yeu doi


//mung ba vui ve
// vui ve iu doi