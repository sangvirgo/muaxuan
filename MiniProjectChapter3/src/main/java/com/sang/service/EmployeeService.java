package com.sang.service;

import com.sang.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee temp);

    void deteleById(int temp);
}
