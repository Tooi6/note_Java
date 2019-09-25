package com.Tooi.springcloud.web;

import com.Tooi.springcloud.pojo.Product;
import com.Tooi.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object products(Model model){
        List<Product> products=productService.listProduct();
        model.addAttribute("ps",products);
        return "products";
    }

}
