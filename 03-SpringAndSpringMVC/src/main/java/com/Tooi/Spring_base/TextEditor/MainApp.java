package com.Tooi.Spring_base.TextEditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring_base/textEditor_Beans.xml");
        TextEditor textEditor= (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();

    }
}
