package com.Tooi.action;

import com.Tooi.pojo.Category;
import com.Tooi.pojo.Product;
import com.Tooi.service.ProductService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Namespace("/")
@ParentPackage("struts-default")
@Results({@Result(name="listJsp",location = "/product/list.jsp"),
    @Result(name = "edit",location = "/product/edit.jsp"),
    @Result(name = "list",location = "listProduct",type = "redirect")})
public class ProductAction {
    @Autowired
    ProductService productService;
    List<Product> productList;
    Product product;


    List<Category> categoryList;

    @Action("listProduct")
    public String list(){
        // System.out.println(this);
        productList =productService.list();
        return "listJsp";
    }

    @Action("editProduct")
    public String edit(){
        product=productService.get(product.getId());
        return "edit";
    }

    @Action("updateProduct")
    public String update(){
        productService.update(product);
        return "list";
    }

    @Action("deleteProduct")
    public String delete(){
        productService.delete(product);
        return "list";
    }

    /**----------------------get set------------------------------*/
    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
