package com.Tooi.Spring_base.evenHandler;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("Spring_base/evenHandler_Beans.xml");
        context.start();
        HelloWorld helloWorld= (HelloWorld) context.getBean("helloWorld");
        helloWorld.getMessage();
        context.stop();
    }
}
