package com.Tooi.springcloud.service;

import com.Tooi.springcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Value("${server.port}")
    String port;
    public List<Product> listProduct(){
        List<Product> products=new ArrayList<>();
        products.add(new Product(1,"product a from port:"+port,50));
        products.add(new Product(2,"product a from port:"+port,100));
        products.add(new Product(3,"product a from port:"+port,150));
        return products;
    }
}
