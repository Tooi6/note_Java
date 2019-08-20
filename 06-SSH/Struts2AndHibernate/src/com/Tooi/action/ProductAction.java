package com.Tooi.action;

import com.Tooi.dao.CategoryDao;
import com.Tooi.dao.ProductDAO;
import com.Tooi.pojo.Category;
import com.Tooi.pojo.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAction {
    ProductDAO productDAO=new ProductDAO();
    CategoryDao categoryDao=new CategoryDao();
    Product product;
    List<Product> productList;
    List<Category> categoryList;
    Category category;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String add(){
        productDAO.add(product);
        return "list";
    }

    public String edit(){
        categoryList = categoryDao.listCategorty();
        product=productDAO.get(product.getId());
        return "edit";
    }

    public String delete(){
        productDAO.delete(product.getId());
        return "list";
    }

    public String update(){
        productDAO.update(product);
        return "list";
    }

    public String list(){
        categoryList = categoryDao.listCategorty();
        if(null!=category){
            category=categoryDao.get(category.getId());
            productList=new ArrayList(category.getProducts());
            return "listJsp";
        }
        productList = productDAO.listProduct();
        return "listJsp";
    }
}
