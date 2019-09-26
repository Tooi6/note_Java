package com.Tooi.springcloud.client;

import com.Tooi.springcloud.pojo.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductClientFeignHystrix implements ProductClientFeign{
    public List<Product> listProduct(){
        List<Product> result=new ArrayList<>();
        result.add(new Product(0,"产品数据服务不可用",0));
        return result;
    }
}
