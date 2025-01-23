package com.demoonetoone;

import com.demoonetoone.dao.AppDAO;
import com.demoonetoone.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoManyToManyApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AppDAO theAppDAO) {
        return runner -> {
//            createCourseAndStudent(theAppDAO);

//            findTheCourseAndStudent(theAppDAO);

//            findTheStudentAndCourse(theAppDAO);

            deleteCourseById(theAppDAO);
        };
    }

    private void deleteCourseById(AppDAO theAppDAO) {
        theAppDAO.deleteCourseById(12);
    }

    private void findTheStudentAndCourse(AppDAO theAppDAO) {
        Student temp=theAppDAO.findStudentAndCourseByStudentId(5);

        System.out.println(temp);
        System.out.println(temp.getListCourse());
    }


    private void findTheCourseAndStudent(AppDAO theAppDAO) {
        Course rs=theAppDAO.findCourseAndStudentByCourseId(10);

        System.out.println(rs);
        System.out.println(rs.getListStudent());

    }

    private void createCourseAndStudent(AppDAO theAppDAO) {
        Student student = new Student("John", "Doe", "john.doe@example.com");

        Instructor instructor = new Instructor("Jane", "Doe", "jane.doe@example.com");

        Course course1 = new Course("Spring Boot - Advanced Sang Sang");
        Course course2 = new Course("Hibernate - Mastery");
        Course course3 = new Course("Microservices with Spring Cloud");

        course1.setInstructor(instructor);
        course2.setInstructor(instructor);
        course3.setInstructor(instructor);

        Review review1 = new Review("Great course!");
        Review review2 = new Review("Very informative.");
        Review review3 = new Review("Excellent content.");

        course1.addReview(review1);
        course2.addReview(review2);
        course3.addReview(review3);

        student.addCoursetoStudent(course1);
        student.addCoursetoStudent(course2);
        student.addCoursetoStudent(course3);

        System.out.println("Saving student: " + student);
        theAppDAO.save(student);

        System.out.println("Done");
    }
}
