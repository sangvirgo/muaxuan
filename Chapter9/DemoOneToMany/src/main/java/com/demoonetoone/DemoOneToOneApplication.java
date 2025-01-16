package com.demoonetoone;

import com.demoonetoone.dao.AppDAO;
import com.demoonetoone.entity.Course;
import com.demoonetoone.entity.Instructor;
import com.demoonetoone.entity.InstructorDetail;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoOneToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOneToOneApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AppDAO theAppDAO) {
        return runner -> {
//            createInstructor(theAppDAO);

//            findInstructor(theAppDAO);

//            findInstructorDetail(theAppDAO);

//            deleteInstructorDetail(theAppDAO);

//            createInstructorWithCourses(theAppDAO);

//            findInstructorWithCourses(theAppDAO);

//            findCourseForInstructor(theAppDAO);

//            findInstructorWithCoursesJoinFetch(theAppDAO);

//            updateCourse(theAppDAO);

//            deleteInstructorWithCourse(theAppDAO);

            deleteCourseById(theAppDAO);
        };
    }

    private void deleteCourseById(AppDAO theAppDAO) {
        theAppDAO.deleteCourseById(10);
        theAppDAO.deleteCourseById(17);
    }

    private void deleteInstructorWithCourse(AppDAO theAppDAO) {
        theAppDAO.deleteInstructorById(1);
    }

    private void updateCourse(AppDAO theAppDAO) {
        Course temp=theAppDAO.findCourseById(10);


        temp.setTitle("Sang");

        theAppDAO.update(temp);
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO theAppDAO) {
        Instructor temp=theAppDAO.findInstructorByIdJoinFetch(1);
        System.out.println(temp.getCourses());
    }

    private void findCourseForInstructor(AppDAO theAppDAO) {
        Instructor tp=theAppDAO.findInstructorById(1);
        System.out.println(tp);

        List<Course> temp=theAppDAO.findCourseByInstructor(1);

        tp.setCourses(temp);
        System.out.println(tp.getCourses());
    }

    private void findInstructorWithCourses(AppDAO theAppDAO) {
        Instructor temp=theAppDAO.findInstructorById(1);

        System.out.println("The instructor: " + temp);
        System.out.println("The associated courses: "+ temp.getCourses());
    }

    private void createInstructorWithCourses(AppDAO theAppDAO) {
        // Create the first InstructorDetail object
        InstructorDetail instructorDetail1 = new InstructorDetail("http://www.youtube.com/channel1", "Guitar");
        // Create the first Instructor object and associate it with the first InstructorDetail
        Instructor instructor = new Instructor("John", "Doe", "john.doe@example.com");
        instructor.setInstructorDetail(instructorDetail1);

        // Create five Course objects
        Course course1 = new Course("Introduction to Java Programming");
        Course course2 = new Course("Web Development with Spring Boot");
        Course course3 = new Course("Data Structures and Algorithms");
        Course course4 = new Course("Database Management Systems");
        Course course5 = new Course("Cloud Computing with AWS");



        
        instructor.add(course1);
        instructor.add(course2);
        instructor.add(course3);
        instructor.add(course4);
        instructor.add(course5);

        theAppDAO.save(instructor);

        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void deleteInstructorDetail(AppDAO theAppDAO) {

        theAppDAO.deleteInstructorDetailById(4);
    }

    private void findInstructorDetail(AppDAO theAppDAO) {
        InstructorDetail temp=theAppDAO.findInstructorDetailById(2);
        System.out.println(temp.getInstructor().toString());
        System.out.println(temp.toString());
    }


    private void findInstructor(AppDAO theAppDAO) {
        Instructor temp=theAppDAO.findInstructorById(1);
        System.out.println(temp.toString());
        System.out.println(temp.getInstructorDetail().toString());
    }

    private void createInstructor(AppDAO theAppDAO) {

        // Create the first InstructorDetail object
        InstructorDetail instructorDetail1 = new InstructorDetail("http://www.youtube.com/channel1", "Guitar");
        // Create the first Instructor object and associate it with the first InstructorDetail
        Instructor instructor1 = new Instructor("John", "Doe", "john.doe@example.com");
        instructor1.setInstructorDetail(instructorDetail1);

        // Create the second InstructorDetail object
        InstructorDetail instructorDetail2 = new InstructorDetail("http://www.youtube.com/channel2", "Piano");
        // Create the second Instructor object and associate it with the second InstructorDetail
        Instructor instructor2 = new Instructor("Jane", "Smith", "jane.smith@example.com");
        instructor2.setInstructorDetail(instructorDetail2);

        // Save the first Instructor (which will also save the first InstructorDetail because of CascadeType.ALL)
        System.out.println("Saving instructor: " + instructor1);
        theAppDAO.save(instructor1);

        // Save the second Instructor (which will also save the second InstructorDetail because of CascadeType.ALL)
        System.out.println("Saving instructor: " + instructor2);
        theAppDAO.save(instructor2);

        System.out.println("Done");
    }
}
