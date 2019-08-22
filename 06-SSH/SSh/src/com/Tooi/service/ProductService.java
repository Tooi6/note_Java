package com.Tooi.service;

import com.Tooi.pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * 获取所有产品
     * @return
     */
    public List<Product> list();

    /**
     * 根据id获取产品
     * @param id
     * @return
     */
    public Product get(int id);

    /**
     * 更新产品信息
     * @param product
     */
    void update(Product product);

    /**
     * 删除产品
     * @param product
     */
    void delete(Product product);
}
