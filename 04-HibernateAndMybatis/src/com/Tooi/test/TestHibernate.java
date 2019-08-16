package com.Tooi.test;

import com.Tooi.pojo.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TestHibernate {
    /** 插入数据
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        for (int i=0;i<10;i++){
            Product p=new Product();
            p.setName("iphone"+i);
            p.setPrice(i);
            session.save(p);
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 通过id获取数据
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();
        session.beginTransaction();

        Product product= (Product) session.get(Product.class,6);

        System.out.println("id 为6的产品为："+product.getName());

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }**/

    /** 删除数据
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Product product= (Product) session.get(Product.class,1);
        session.delete(product);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/
    /** 更新数据
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();
        session.beginTransaction();

        Product product= (Product) session.get(Product.class,6);
        product.setName("iphone-modified");
        session.update(product);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 使用hql查询
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        String name="iphone";
        Query query=session.createQuery("from Product p where p.name like ?");
        query.setString(0,"%"+name+"%");
        List<Product> list=query.list();
        for (Product product:list){
            System.out.println(product.getName());
        }

        session.beginTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 使用 Criteria 进行数据查询
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        String name="iphone";
        Criteria criteria=session.createCriteria(Product.class);
        criteria.add(.Restrictionslike("name","%"+name+"%"));
        List<Product> products= criteria.list();
        for (Product product:products){
            System.out.println(product.getName());
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 使用sql查询
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        String name="iphone";
        String sql="select * from product_ p where p.name like '%"+name+"%'";

        Query q=session.createSQLQuery(sql);
        List<Object[]> list=q.list();
        for (Object[] objects:list){
            for (Object object:objects){
                System.out.print(object+"\t");
            }
            System.out.println();
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

}














