package com.Tooi.dao;

import com.Tooi.pojo.Category;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public void add(Category category){
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(category);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public List<Category> listCategorty(){
        List<Category> result=new ArrayList<>();

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Query q=session.createQuery("from Category c");

        result=q.list();

        session.close();
        sessionFactory.close();

        return result;
    }

    public Category get(int id){
        Category category=null;
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();

        category= (Category) session.get(Category.class,id);

        session.close();
        sessionFactory.close();

        return category;
    }

    public void update(Category category){
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.update(category);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void delete(int id){
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Category category= (Category) session.get(Category.class,id);
        session.delete(category);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }




}
