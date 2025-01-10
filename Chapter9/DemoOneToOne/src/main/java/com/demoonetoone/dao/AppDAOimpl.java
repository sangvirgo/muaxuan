package com.demoonetoone.dao;

import com.demoonetoone.entity.Instructor;
import com.demoonetoone.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AppDAOimpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOimpl(EntityManager theEntityManager) {
        this.entityManager=theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor temp=entityManager.find(Instructor.class, theId);

        entityManager.remove(temp);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }


    // want only delete detail
    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail temp=entityManager.find(InstructorDetail.class, theId);

        temp.getInstructor().setInstructorDetail(null);
        entityManager.remove(temp);    }
}
