package com.Tooi.test;

import com.Tooi.pojo.Category;
import com.Tooi.pojo.Product;
import com.Tooi.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    /** 一对多
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Category category=new Category();
        category.setName("c1");
        session.save(category);

        Product p= (Product) session.get(Product.class,8);
        p.setCategory(category);
        session.update(p);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 一对多
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Category category= (Category) session.get(Category.class,2);
        Set<Product> products=category.getProducts();
        for (Product product:products){
            System.out.println(product.getName());
        }
    }*/

    /** 多对多
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        // 增加三个user
        Set<User> users=new HashSet<>();
        for (int i=0;i<3;i++){
            User user=new User();
            user.setName("Tooi"+i);
            users.add(user);
            session.save(user);
        }

        // 产品1被用户0 1 2 购买
        Product product1= (Product) session.get(Product.class,3);
        product1.setUsers(users);
        session.save(product1);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 事务
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Product product3 = (Product) session.get(Product.class,3);
        session.delete(product3);
        Product product4 = (Product) session.get(Product.class,4);
        product4.setName("长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称");
        session.update(product4);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 属性延迟加载
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Product product = (Product) session.load(Product.class,6);
        System.out.println("log1");
        // 使用load加载对象，只有访问了对象的属性，hibernate才会到数据库中进行查询。
        System.out.println(product.getName());
        System.out.println("log2");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 关系延迟加载
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Category category= (Category) session.get(Category.class,2);   // 延迟加载，此时只会查询category表
        System.out.println("log1");
        System.out.println(category.getProducts());   // 这里才会去查询 product 表
        System.out.println("log2");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 级联 delete
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Category category= (Category) session.get(Category.class,2);
        session.delete(category);   // delete级，把对应的product一起删除

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 级联 save-update
     *  all： delete+save-update
     *  none：没有，默认
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Category category= (Category) session.get(Category.class,2);
        Product p1 = new Product();
        p1.setName("product_201");
        Product p2 = new Product();
        p2.setName("product_202");
        Product p3 = new Product();
        p3.setName("product_203");
        category.getProducts().add(p1);
        category.getProducts().add(p2);
        category.getProducts().add(p3);

        session.getTransaction().commit();  // save-update级，提交后自动在数据库添加这三个产品
        session.close();
        sessionFactory.close();
    }*/

    /** 一级缓存 同一个session下
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("log");
        Category category1= (Category) session.get(Category.class,2);  // 第一次从数据库中取出，输出sql语句
        System.out.println("log2");
        Category category2= (Category) session.get(Category.class,2);  // 第二次从session缓存中取出，不输出sql语句
        System.out.println("log3");

        session.getTransaction().commit();  // save-update级，提交后自动在数据库添加这三个产品
        session.close();
        sessionFactory.close();
    }*/

    /** 二级缓存 不同session
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();

        Category category1= (Category) session1.get(Category.class,1);
        System.out.println("log1");
        Category category2= (Category) session1.get(Category.class,1);
        System.out.println("log2");
        session1.getTransaction().commit();
        session1.close();


        Session session2=sessionFactory.openSession();
        session2.beginTransaction();
        Category category3= (Category) session2.get(Category.class,1);  // 开启二级缓存后，不同session只查询一次，但级联对象在不同session下会再次查询
        System.out.println("log3");

        session2.getTransaction().commit();
        session2.close();
        sessionFactory.close();
    }*/

    /** 分页查询
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String name="类别";
        Criteria criteria=session.createCriteria(Category.class);
        criteria.add(Restrictions.like("name","%"+name+"%"));
        criteria.setFirstResult(0);   // 从第0个开始
        criteria.setMaxResults(6);    // 最多6个

        List<Category> list=criteria.list();
        for(Category category:list){
            System.out.println(category.getName());
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** load & get
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("log1");
        Product product1= (Product) session.get(Product.class,4);
        System.out.println(product1);
        System.out.println("log2");
        Product product2= (Product) session.load(Product.class,9);
        System.out.println("log3");
        System.out.println(product2);
        System.out.println("log4");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** openSession
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session1=sessionFactory.openSession();
        Session session2=sessionFactory.openSession();

        System.out.println(session1==session2);
        session1.close();
        session2.close();
        sessionFactory.close();
    }*/

    /** getCurrentSession 同一个线程
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session1=sessionFactory.getCurrentSession();
        Session session2=sessionFactory.getCurrentSession();

        System.out.println(session1==session2);

        session1.close();
        //session2.close();   同一个session 只要关闭一次
        sessionFactory.close();
    }*/

    /** getCurrentSession 不同线程下获取的session对象不同
    static Session s1;
    static Session s2;
    public static void main(String[] args) throws InterruptedException {
        final SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Thread t1=new Thread(){
            public void run(){
                s1=sessionFactory.getCurrentSession();
            }
        };
        t1.start();
        Thread t2=new Thread(){
          public void run(){
              s2=sessionFactory.getCurrentSession();
          }
        };
        t2.start();

        t1.join();
        t2.join();
        System.out.println(s1==s2);
    }*/

    /** openSession 查询不用放在事务中
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.get(Product.class,9);   // 不需要放在事务中

        session.close();
        sessionFactory.close();
    }*/

    /** getCurrentSession 所有操作都要放在事务中
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.get(Product.class,9);  // 报错，需要放在事务中

        session.close();
        sessionFactory.close();
    }*/

    /** query.iterate() 先查询出所有符合条件的id，后面遍历再通过id现在缓存中查找，没有的话再查询数据库
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        // 先查询id=9的数据 name=iphone6
        session.get(Product.class,9);

        String name="iphone";
        Query query=session.createQuery("from Product p where p.name like ?");
        query.setString(0,"%"+name+"%");
        Iterator<Product> iterator=query.iterate();
        while (iterator.hasNext()){
            Product product=iterator.next();
            System.out.println(product.getName());    //id=9的数据不再通过数据库查询，而通过缓存之间获取
        }

        session.getTransaction();
        session.close();
        sessionFactory.close();
    }*/

    /** 查询总数
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        String name="iphone";
        Query query=session.createQuery("select count(*) from Product p where p.name like ?");
        query.setString(0,"%"+name+"%");
        long total= (long) query.uniqueResult();
        System.out.println(total);

        session.getTransaction();
        session.close();
        sessionFactory.close();
    }*/

    /** 乐观锁 增加version字段
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session1=sessionFactory.openSession();
        Session session2=sessionFactory.openSession();
        session1.beginTransaction();
        session2.beginTransaction();

        Product product1= (Product) session1.get(Product.class,9);
        System.out.println("产品原本的价格是："+product1.getPrice());

        product1.setPrice(product1.getPrice()+1000);
        Product product2= (Product) session2.get(Product.class,9);
        product2.setPrice(product2.getPrice()+1000);

        session1.update(product1);
        // 增加字段后更新session2，抛出异常
        session2.update(product2);

        session1.getTransaction().commit();
        session2.getTransaction().commit();

        Product product= (Product) session1.get(Product.class,6);
        System.out.println("经过两次更新后的价格是："+product.getPrice());

        session1.close();
        session2.close();
        sessionFactory.close();
    }*/

    /** 连接池 测试
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();
        session.beginTransaction();

        session.createQuery("from Category ").list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 多对一
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();
        session.beginTransaction();

        Category category= (Category) session.get(Category.class,2);
        Set<Product> products= category.getProducts();
        for (Product product:products){
            System.out.println(product.getName());
        }


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

    /** 多对多
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Set<User> users=new HashSet<>();
        for (int i=3;i<6;i++){
            User user=new User();
            user.setName("user"+i);
            users.add(user);
            session.save(user);
        }

        Product product= (Product) session.get(Product.class,9);
        product.setUsers(users);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }*/

}














