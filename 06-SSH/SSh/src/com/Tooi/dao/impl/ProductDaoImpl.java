package com.Tooi.dao.impl;

import com.Tooi.dao.ProductDAO;
import com.Tooi.pojo.Product;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends HibernateTemplate implements ProductDAO {

    @Override
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }


    @Override
    public List<Product> list() {
        return find("from Product");
    }

    @Override
    public void add(Product p) {
        save(p);
    }

    @Override
    public Product get(int id) {
        return get(Product.class, id);
    }

    @Override
    public void update(Product product) {
        super.update(product);
    }

    @Override
    public void delete(Product product) {
        super.delete(product);
    }
}
