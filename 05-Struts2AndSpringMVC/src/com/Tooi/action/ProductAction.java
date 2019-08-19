package com.Tooi.action;

import com.Tooi.pojo.Category;
import com.Tooi.pojo.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Namespace("/")
@ParentPackage("struts-default")
@Results({@Result(name="show",location = "/show.jsp"),
    @Result(name="home",location = "/index.jsp")})
public class ProductAction extends ActionSupport {
    private Product product;
    private List<Product> products;
    private List<Integer> selectProducts;
    private List<Category> categories = new ArrayList<>();
    private Date date;
    private String name;

    public ProductAction(){
        System.out.println("product action instance : "+this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Integer> getSelectProducts() {
        return selectProducts;
    }

    public void setSelectProducts(List<Integer> selectProducts) {
        this.selectProducts = selectProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Action("showProduct")
    public String show(){
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        System.out.println("request:\t" + request);
        System.out.println("response:\t" + response);

        product=new Product();
        product.setName("iphone7");
        return "show";
    }

    @Action("addProduct")
    public String add(){
        Map m= ActionContext.getContext().getSession();
        m.put("name",product.getName());
        System.out.println("product.name:"+product.getName());
        return "show";
    }

    @Action("listProduct")
    public String list(){
        products = new ArrayList<>();
        selectProducts=new ArrayList<>();

        Category category1=new Category();
        category1.setId(1);
        category1.setName("category1");
        for (int i=1;i<=3;i++){
            Product product=new Product();
            product.setId(i);
            product.setName("product"+i);
            products.add(product);
        }
        category1.setProducts(products);

        //products.clear();
        Category category2=new Category();
        category2.setId(2);
        category2.setName("category2");
        for (int i=4;i<=6;i++){
            Product product=new Product();
            product.setId(i);
            product.setName("product"+i);
            products.add(product);
        }
        category2.setProducts(products);

        categories.add(category1);
        categories.add(category2);

        selectProducts.add(2);
        selectProducts.add(3);

        return "list";
    }

    @Action("addPageProduct")
    public String addPage(){
        name = "default name";
        return "addPage";
    }

    /** 表单验证，当没有输入产品名称时加入错误信息
    public void validate(){
        if(product.getName().length()==0){
            addFieldError("product.name","name can't be empty");
        }

    }*/

}
