package com.Tooi.helloworld;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
    /**
    // 使用 ApplicationContext 获取bean
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj= (HelloWorld) context.getBean("helloWorld");
        System.out.println(obj.getMessage());
    }*/

    /**
    // 使用 XmlBeanFactory 获取bean （已过时）
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(obj.getMessage());
     }*/

    /**
    // 使用FileSystemXmlApplicationContext 获取bean
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\work\\IdeaProjects\\note_Java\\03-SpringAndSpringMVC\\src\\main\\resources\\Beans.xml");
        HelloWorld helloWorld= (HelloWorld) context.getBean("helloWorld");
        System.out.println(helloWorld.getMessage());
    }*/

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld objA= (HelloWorld) context.getBean("helloWorld2");
        objA.setMessage("im object A");
        System.out.println(objA.getMessage());
        HelloWorld objB= (HelloWorld) context.getBean("helloWorld2");
        System.out.println(objB.getMessage());
    }
}
