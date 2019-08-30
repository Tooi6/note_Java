package com.tooi.springboot.web;

import com.tooi.springboot.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(Model model){
        String htmlContent = "<p style='color:red'>红色的文字</p>";
        Product currentProduct = new Product(5,"product 5",250);
        model.addAttribute("htmlContent",htmlContent);
        model.addAttribute("currentProduct",currentProduct);
        boolean testBoolean = false;
        model.addAttribute("testBoolean",testBoolean);

        List<Product> products=new ArrayList<>();
        products.add(new Product(1,"product a",50));
        products.add(new Product(2,"product b",100));
        products.add(new Product(3,"product c",150));
        products.add(new Product(4,"product d",200));
        products.add(currentProduct);
        products.add(new Product(6,"product e",300));
        products.add(new Product(7,"product f",350));
        products.add(new Product(8,"product g",400));
        products.add(new Product(9,"product h",450));
        model.addAttribute("products",products);

        Date now=new Date();
        model.addAttribute("now",now);

        return "test";
    }
}
