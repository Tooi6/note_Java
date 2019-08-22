package com.Tooi.service.impl;

import com.Tooi.dao.ProductDAO;
import com.Tooi.pojo.Product;
import com.Tooi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")

    public List<Product> list() {
        List<Product> products=productDAO.list();
        // 如果产品为空则生成几个产品加进去
        if(products.isEmpty()){
            for (int i=0;i<5;i++){
                //if (i==2) throw new RuntimeException();
                Product product=new Product();
                product.setName("product"+i);
                productDAO.add(product);
            }
        }
        return products;
    }

    @Override
    public Product get(int id) {
        Product product=null;
        product=productDAO.get(id);
        return product;
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void delete(Product product) {
        productDAO.delete(product);
    }

    /** -----------------------------get set------------------------------**/
    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
