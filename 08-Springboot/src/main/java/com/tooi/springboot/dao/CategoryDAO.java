package com.tooi.springboot.dao;

import com.tooi.springboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
    public List<Category> findByName(String name);
    public List<Category> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name,int id);
}
