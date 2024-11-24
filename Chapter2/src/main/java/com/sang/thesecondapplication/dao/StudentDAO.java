package com.sang.thesecondapplication.dao;

import com.sang.thesecondapplication.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void updateTheStudent(Student temp);

    void deleteById(int  id);

    int deleteAll();
}
