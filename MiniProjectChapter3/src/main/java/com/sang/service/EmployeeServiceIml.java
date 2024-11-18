package com.sang.service;

import com.sang.dao.EmployeeRepository;
import com.sang.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIml implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceIml(EmployeeRepository theEmployee) {
        this.employeeRepository=theEmployee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result= employeeRepository.findById(theId);

        Employee temp=null;
        if(result.isPresent()) {
            temp=result.get();
        } else {
            throw new RuntimeException("Did not find employee id - "+ theId);
        }

        return temp;
    }

    @Transactional
    @Override
    public Employee save(Employee temp) {
        return employeeRepository.save(temp);
    }

    @Transactional
    @Override
    public void deteleById(int temp) {
        employeeRepository.deleteById(temp);
    }
}
