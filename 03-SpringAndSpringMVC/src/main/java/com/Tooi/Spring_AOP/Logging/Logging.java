package com.Tooi.Spring_AOP.Logging;

public class Logging {

    public void beforeAdvice(){
        System.out.println("Going to setup profile.");
    }
    public void afterAdviice(){
        System.out.println("student profile has been setup.");
    }
    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning:"+retVal.toString());
    }
    public void afterRhrowingAdvice(IllegalArgumentException ex){
        System.out.println("There has been an expection:" + ex.toString());
    }
}
