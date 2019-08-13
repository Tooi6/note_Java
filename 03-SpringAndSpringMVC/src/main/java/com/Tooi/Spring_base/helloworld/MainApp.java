package com.Tooi.Spring_base.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    /**
    // 使用 ApplicationContext 获取bean
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring_base/helloworld_Beans.xml");
        HelloWorld obj= (HelloWorld) context.getBean("helloWorld");
        System.out.println(obj.getMessage());
    }*/

    /**
    // 使用 XmlBeanFactory 获取bean （已过时）
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Spring_base/helloworld_Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(obj.getMessage());
     }*/

    /**
    // 使用FileSystemXmlApplicationContext 获取bean
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\work\\IdeaProjects\\note_Java\\03-SpringAndSpringMVC\\src\\main\\resources\\Spring_base\\helloworld_Beans.xml");
        HelloWorld helloWorld= (HelloWorld) context.getBean("helloWorld");
        System.out.println(helloWorld.getMessage());
    }*/

    /**
    // 生命周期
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring_base/helloworld_Beans.xml");
        HelloWorld objA= (HelloWorld) context.getBean("helloWorld2");
        objA.setMessage("im object A");
        System.out.println(objA.getMessage());
        HelloWorld objB= (HelloWorld) context.getBean("helloWorld2");
        System.out.println(objB.getMessage());
    }*/

    /**
    //
    public static void main(String[] args) {
        AbstractApplicationContext context=new ClassPathXmlApplicationContext("Spring_base/helloworld_Beans.xml");
        HelloWorld obj= (HelloWorld) context.getBean("helloWorld");
        System.out.println(obj.getMessage());
        context.registerShutdownHook();
    }*/

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorld helloWorld=context.getBean(HelloWorld.class);
        helloWorld.setMessage("hello wrold!");
        System.out.println(helloWorld.getMessage());
    }
}
