package com.demoonetoone.dao;

import com.demoonetoone.entity.Course;
import com.demoonetoone.entity.Instructor;
import com.demoonetoone.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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

        List<Course> tempCourse=temp.getCourses();

        for(Course t: tempCourse) {
            t.setInstructor(null);
        }

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

    @Override
    public List<Course> findCourseByInstructor(int theId) {
        TypedQuery<Course> query=entityManager.createQuery(
                "from Course where instructor.id=:data", Course.class
        );

        query.setParameter("data", theId);

        List<Course> rs=query.getResultList();
        return rs;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i JOIN FETCH i.courses where i.id=:data", Instructor.class
        );

        query.setParameter("data", theId);

        Instructor rs = query.getSingleResult();
        return rs;
    }

    @Override
    @Transactional
    public void update(Course temp) {
        entityManager.merge(temp);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course temp=entityManager.find(Course.class, theId);
        entityManager.remove(temp);
    }

    @Override
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }
}
