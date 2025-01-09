package com.demoonetoone;

import com.demoonetoone.dao.AppDAO;
import com.demoonetoone.entity.Instructor;
import com.demoonetoone.entity.InstructorDetail;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

            deleteInstructor(theAppDAO);
        };
    }

    private void deleteInstructor(AppDAO theAppDAO) {
        theAppDAO.deleteInstructorById(1);
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
