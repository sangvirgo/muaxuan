package com.demoonetoone.dao;

import com.demoonetoone.entity.Course;
import com.demoonetoone.entity.Instructor;
import com.demoonetoone.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCourseByInstructor(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Course temp);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);
}
