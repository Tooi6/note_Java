package com.Tooi.test;

import com.Tooi.dao.CategoryDao;
import com.Tooi.pojo.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    private static ApplicationContext context=new ClassPathXmlApplicationContext(
            new String[]{"applicationContext.xml"});
    private static CategoryDao categoryDao= (CategoryDao) context.getBean("categoryDao");


    /** 测试 增删改查
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
        CategoryDao categoryDao= (CategoryDao) context.getBean("categoryDao");
        Category category=new Category();
        // save
        category.setName("category");
        categoryDao.save(category);
        // get
        Category category1=categoryDao.get(Category.class,1);
        System.out.println(category1.getName());
        // delete
        Category category2=new Category();
        category2.setId(10);
        categoryDao.delete(category2);
        // update
        category1.setName("update");
        categoryDao.update(category1);
    }*/

    /** 分页查询
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
        CategoryDao categoryDao= (CategoryDao) context.getBean("categoryDao");
        // Detached:分离的   Criteria：标准，原则
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Category.class);
        int start=1;
        int count=6;
        List<Category> categoryList=categoryDao.findByCriteria(detachedCriteria,start,count);
        for(Category category:categoryList){
            System.out.println(category.getName());
        }
    }*/

    /** 返回总数
    public static void main(String[] args) {
        List<Long> l=categoryDao.find("select count(*) from Category c");
        long total=l.get(1);
        System.out.println(total);

    }*/

    public static void main(String[] args) {
        // 使用hql查询
        List<Category> categoryList=categoryDao.find(
                "from Category c where c.name like ?","%c%");
        for (Category category:categoryList){
            System.out.println(category.getName());
        }
        System.out.println("---------------");
        // 使用DetachedCriteria
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Category.class);
        detachedCriteria.add(Restrictions.like("name","%category%"));
        categoryList=categoryDao.findByCriteria(detachedCriteria);
        for (Category category:categoryList){
            System.out.println(category.getName());
        }
    }
}
