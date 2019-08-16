package com.Tooi.test;

import com.Tooi.pojo.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCategory {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Category category=new Category();
        category.setName("类别1");
        session.save(category);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
