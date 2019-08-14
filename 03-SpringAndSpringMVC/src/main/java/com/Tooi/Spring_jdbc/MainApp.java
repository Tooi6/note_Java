package com.Tooi.Spring_jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring_jdbc/Spring_jdbc.xml");
        StudentJDBCTemplate studentJDBCTemplate= (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
        System.out.println("---------Records Creation-----------");
        studentJDBCTemplate.create("you",15);
        studentJDBCTemplate.create("csy",14);

    }
}
