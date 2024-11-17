package com.sang.dao;

import com.sang.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImp(EntityManager TheentityManager) {
        this.entityManager=TheentityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee temp) {
        return entityManager.merge(temp);
    }

    @Override
    public void deteleById(int temp) {
        entityManager.remove(entityManager.find(Employee.class, temp));
    }
}
