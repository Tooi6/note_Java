package com.Tooi.action;

import com.Tooi.pojo.Category;
import com.Tooi.service.CategoryService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Namespace("/")
@ParentPackage("struts-default")
@Results({@Result(name = "listJsp",location = "/category/list.jsp")})
public class CategoryAction {
    List<Category> categoryList;
    @Autowired
    CategoryService categoryService;



    @Action("listCategory")
    public String list(){
        categoryList=categoryService.list();
        return "listJsp";
    }


    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
