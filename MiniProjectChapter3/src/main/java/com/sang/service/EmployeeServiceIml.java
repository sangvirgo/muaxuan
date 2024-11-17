package com.sang.service;

import com.sang.dao.EmployeeDAO;
import com.sang.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeServiceIml implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceIml(EmployeeDAO theEmployee) {
        this.employeeDAO=theEmployee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee temp) {
        return employeeDAO.save(temp);
    }

    @Transactional
    @Override
    public void deteleById(int temp) {
        employeeDAO.deteleById(temp);
    }


}
