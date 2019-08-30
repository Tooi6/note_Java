package com.tooi.springboot.web;

import com.tooi.springboot.dao.CategoryDAO;
import com.tooi.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
public class CategoryController2 {
    @Autowired
    CategoryDAO categoryDAO;

    /**
     * 以json的方式响应
     */

    @GetMapping("/category")
    public List<Category> list(Model m,
                                       @RequestParam(value = "start", defaultValue = "0") int start,
                                       @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page = categoryDAO.findAll(pageable);
        m.addAttribute("page", page);
        return page.getContent();
    }

    @GetMapping("/category/{id}")
    public Category get(@PathVariable("id") int id){
        Category category=categoryDAO.getOne(id);
        System.out.println("get:"+category);
        return category;
    }

    @PutMapping("/category")
    public void add(@RequestBody Category category){
        System.out.println("springboot 接收到浏览器以json提交的数据："+category);
    }

    /**
     * 使用Restful，以jsp方式响应，把RestController改成Controller
     *
     */

    @GetMapping("/categories")
    public String listCategory(Model m,
                               @RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page = categoryDAO.findAll(pageable);
        m.addAttribute("page", page);
        return "category/list";
    }


    @PostMapping("/categories")
    public String addCategory(Category category){
        categoryDAO.save(category);
        return "redirect:/categories";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category category){
        categoryDAO.delete(category);
        System.out.println("删除成功！");
        return "redirect:/categories";
    }

    @PutMapping("/categories/{id}")
    public String updateCategory(Category category){
        categoryDAO.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}")
    public String getCategory(@PathVariable("id") int id,Model model){
        Category category=categoryDAO.getOne(id);
        model.addAttribute("c",category);
        return "category/edit";
    }
}
