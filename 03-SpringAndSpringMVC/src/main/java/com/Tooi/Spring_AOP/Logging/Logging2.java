package com.Tooi.Spring_AOP.Logging;

import org.aspectj.lang.annotation.*;

@Aspect
public class Logging2 {
    @Pointcut("execution(* com.Tooi.Spring_AOP.Logging.*.*(..))")
    private void selectAll(){}

    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("Going to setup profile.");
    }

    @After("selectAll()")
    public void afterAdviice(){
        System.out.println("student profile has been setup.");
    }

    @AfterReturning(pointcut = "selectAll()",returning = "retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning:"+retVal.toString());
    }

    @AfterThrowing(pointcut = "selectAll()",throwing = "ex")
    public void afterRhrowingAdvice(IllegalArgumentException ex){
        System.out.println("There has been an expection:" + ex.toString());
    }
}
