package com.Tooi.service.impl;

import com.Tooi.dao.CategoryDao;
import com.Tooi.pojo.Category;
import com.Tooi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")

    public List<Category> list(){
        List<Category> categoryList=categoryDao.list();
        return categoryList;
    }
}
