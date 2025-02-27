package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDAO {
 int add(Student student);
 int delete(int id);
 int update(Student student);
 Student getbyid(int id);
 List<Student>getall();
 List<Student> sortByName();
 List<Student> sortById();
 List<Student> sortByMarks();
}
