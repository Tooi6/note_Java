package com.tooi.springboot.test;

import com.tooi.springboot.Application;
import com.tooi.springboot.dao.CategoryDAO;
import com.tooi.springboot.mapper.CategoryMapper;
import com.tooi.springboot.pojo.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class TestJPA {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryDAO categoryDAO;

    //@Before
    public void before(){
        List<Category> categories=categoryDAO.findAll();
        for (Category category:categories){
            categoryDAO.delete(category);
        }
        for (int i=0;i<10;i++){
            Category category=new Category();
            category.setName("category 1"+i);
            categoryDAO.save(category);
        }
    }

    @Test
    public void test1(){
        List<Category> categories=categoryMapper.findAll();
        for (Category category:categories){
            System.out.println(category.getName());
        }
    }


    @Test
    public void test3(){
        System.out.println("查询名称模糊查询：id 大于75，并且名称正排序：");
        List<Category> categories=categoryDAO.findByNameLikeAndIdGreaterThanOrderByNameAsc("%e%",75);
        for (Category category:categories){
            System.out.println("c.getName():"+category.getName());
        }
    }
}
