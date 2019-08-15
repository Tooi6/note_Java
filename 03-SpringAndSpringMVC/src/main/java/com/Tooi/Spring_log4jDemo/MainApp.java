package com.Tooi.Spring_log4jDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class MainApp {
    static Logger log=Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring_log/Spring_log.xml");
        log.info("Going to Create HelloWorld Obj");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        System.out.println(obj.getMessage());
        log.info("Exiting the program");
    }
}
