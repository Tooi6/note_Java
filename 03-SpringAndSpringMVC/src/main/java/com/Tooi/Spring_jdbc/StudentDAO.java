package com.Tooi.Spring_jdbc;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {

    public void setDataSource(DataSource ds);

    public void create(String name,Integer age);

    public Student getStudent(Integer id);

    public List<Student> listStudents();

    public void delete(Integer id);

    public void update(Integer id,Integer age);
}
