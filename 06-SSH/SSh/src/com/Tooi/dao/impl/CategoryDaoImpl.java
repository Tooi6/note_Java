package com.Tooi.dao.impl;

import com.Tooi.dao.CategoryDao;
import com.Tooi.pojo.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("categoryDao")
public class CategoryDaoImpl extends HibernateTemplate implements CategoryDao {

    @Override
    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Category> list() {
        return find("from Category ");
    }
}
