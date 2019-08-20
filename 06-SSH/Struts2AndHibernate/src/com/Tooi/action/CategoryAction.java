package com.Tooi.action;

import com.Tooi.dao.CategoryDao;
import com.Tooi.pojo.Category;

import java.util.List;

public class CategoryAction {
    CategoryDao categoryDao=new CategoryDao();
    Category category;
    List<Category> categoryList;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String list(){
        categoryList = categoryDao.listCategorty();
        return "listJsp";
    }

    public String add(){
        categoryDao.add(category);
        return "list";
    }

    public String edit(){
        category=categoryDao.get(category.getId());
        return "edit";
    }

    public String update(){
        categoryDao.update(category);
        return "list";
    }

    public String delete(){
        categoryDao.delete(category.getId());
        return "list";
    }

    public String getProductBy(){

        return "list";
    }


}
