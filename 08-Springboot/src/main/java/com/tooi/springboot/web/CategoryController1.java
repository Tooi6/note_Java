package com.tooi.springboot.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tooi.springboot.mapper.CategoryMapper;
import com.tooi.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@Controller
public class CategoryController1 {
    /*@Autowired
    CategoryDAO categoryDAO;*/
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model model,
                               @RequestParam(value="start",defaultValue = "0")int start,
                               @RequestParam(value = "size",defaultValue = "5")int size) throws Exception{
        PageHelper.startPage(start,size,"id desc");
        List<Category> categories=categoryMapper.findAll();
        model.addAttribute("categories",categories);
        PageInfo<Category> page=new PageInfo<>(categories);
        model.addAttribute("page",page);
        return "listCategory";
    }

    @RequestMapping("/editCategory")
    public String editCategory(Model model,@RequestParam(value = "id")int id){
        Category category=categoryMapper.get(id);
        model.addAttribute("c",category);
        return "editCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "id") int id){
        Category category=new Category();
        category.setId(id);
        category.setName(name);
        categoryMapper.update(category);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(value = "id") int id){
        categoryMapper.delete(id);
        return "redirect:listCategory";
    }
    @RequestMapping("/addCategory")
    public String deleteCategory(@RequestParam(value = "name") String name){
        Category category=new Category();
        category.setName(name);
        categoryMapper.save(category);
        return "redirect:listCategory";
    }
}
