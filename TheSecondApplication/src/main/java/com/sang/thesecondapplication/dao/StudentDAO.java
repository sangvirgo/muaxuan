package com.sang.thesecondapplication.dao;

import com.sang.thesecondapplication.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(int id);
}
