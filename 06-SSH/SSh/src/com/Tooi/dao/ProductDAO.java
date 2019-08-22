package com.Tooi.dao;

import com.Tooi.pojo.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> list();
    void add(Product p);
    Product get(int id);
    void update(Product product);
    void delete(Product product);
}
