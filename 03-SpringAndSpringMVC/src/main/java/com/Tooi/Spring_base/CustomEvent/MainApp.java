package com.Tooi.Spring_base.CustomEvent;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("Spring_base/customEvent_Beans.xml");
        CustomEventPublisher customEventPublisher = (CustomEventPublisher) context.getBean("customEventPublisher");
        customEventPublisher.publish();
        customEventPublisher.publish();
    }
}
