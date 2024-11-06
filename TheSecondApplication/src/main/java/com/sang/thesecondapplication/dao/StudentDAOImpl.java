package com.sang.thesecondapplication.dao;

import com.sang.thesecondapplication.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

//    define fields for entity manager
    private final EntityManager entityManager;

//constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
//        create a query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
//      =:theData is a placeholder, jpql name parameter
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

//        set query parameter
        theQuery.setParameter("theData", lastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateTheStudent(Student temp) {
        entityManager.merge(temp);
    }


    //    delete the row in tha database
//    int numRow=entityManager.createQuery("DELETE FROM Student WHERE lastName='Smith').setParameter("theId", id).executeUpdate();
    @Override
    @Transactional
    public void deleteById(int id) {
        Student temp=entityManager.find(Student.class, id);
        if(temp!=null) {
            entityManager.remove(temp);
        } else {
            throw new IllegalArgumentException("Student with id "+id+" not found");
        }
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }


}
