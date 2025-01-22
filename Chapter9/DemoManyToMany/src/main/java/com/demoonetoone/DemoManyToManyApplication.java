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

            findTheCourseAndStudent(theAppDAO);
        };
    }


    private void findTheCourseAndStudent(AppDAO theAppDAO) {
        Course rs=theAppDAO.findCourseAndStudentByCourseId(10);

        System.out.println(rs);
        System.out.println(rs.getListStudent());

    }

    private void createCourseAndStudent(AppDAO theAppDAO) {
        Course course = new Course("Spring Boot - Advanced Techniques");

        // Create three Student objects
        Student student1 = new Student("John", "Doe", "john.doe@example.com");
        Student student2 = new Student("Jane", "Smith", "jane.smith@example.com");
        Student student3 = new Student("Mary", "Johnson", "mary.johnson@example.com");

        // Associate the students with the course
        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);

        // Save the course (which will also save the students because of CascadeType.ALL)
        System.out.println("Saving course: " + course);
        theAppDAO.save(course);

        System.out.println("Done");
    }
}
