package com.Tooi.Spring_jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    public void setDataSource(DataSource ds) {
        this.dataSource=ds;
        this.jdbcTemplateObject=new JdbcTemplate(ds);
    }

    public void create(String name, Integer age) {
        String SQL="insert into Student(name,age) values(?,?)";
        jdbcTemplateObject.update(SQL,name,age);
        System.out.println("Create Recode Name = "+name+" Age = "+age);
        return;
    }

    public Student getStudent(Integer id) {
        return null;
    }

    public List<Student> listStudents() {
        return null;
    }

    public void delete(Integer id) {

    }

    public void update(Integer id, Integer age) {

    }
}
