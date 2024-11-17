package com.sang.dao;

import com.sang.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee temp);

    void deteleById(int temp);
}
