package com.demoaop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpression {

    @Pointcut("execution(* com.demoaop.DAO.*.*(..)))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.demoaop.DAO.*.get*(..))")
    public void forGetter() {}

    @Pointcut("execution(* com.demoaop.DAO.*.set*(..))")
    public void forSetter() {}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter() )")
    public void forDaoPackageNoSetterNoGetter() {}
}
