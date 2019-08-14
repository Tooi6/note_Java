package com.Tooi.Spring_AOP.Logging;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    /*
    public static void main(String[] args) {
         ApplicationContext context =new ClassPathXmlApplicationContext("Spring_AOP/Logging.xml");
         Student student= (Student) context.getBean("student");
         System.out.println("age = "+student.getAge());
         System.out.println("name = "+student.getName());
         student.printThrowException();
    }*/
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring_AOP/Logging2.xml");
        Student student= (Student) context.getBean("student");
        System.out.println("name："+student.getName());
        System.out.println("age："+student.getAge());
        student.printThrowException();
    }
}
