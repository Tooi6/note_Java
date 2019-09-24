package com.Tooi.springcloud.controller;

import com.Tooi.springcloud.pojo.Product;
import com.Tooi.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object products(){
        List<Product> products=productService.listProduct();
        return products;
    }
}
