package com.tooi.springboot.mapper;

import com.tooi.springboot.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {

    // @Select("select * from category")
    List<Category> findAll();

    public int save(Category category);

    public void delete(int id);

    public  Category get(int id);

    public int update(Category category);
}
