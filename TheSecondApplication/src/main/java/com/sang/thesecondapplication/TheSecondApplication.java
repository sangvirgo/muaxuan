package com.sang.thesecondapplication;

import com.sang.thesecondapplication.dao.StudentDAO;
import com.sang.thesecondapplication.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TheSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheSecondApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1=new Student("Han", "Phan", "hihi@gmai.com");
		Student student2 = new Student("John", "Doe", "john.doe@example.com");
		Student student3 = new Student("Jane", "Smith", "jane.smith@example.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
//create a student object
		System.out.println("Creating a new student object");
		Student tempStudent=new Student("Sang", "Nguyen", "tansang06092004@gmail.com");

//		save the student object
		System.out.println("Saving the student object");
		studentDAO.save(tempStudent);

//		display the student object
		System.out.println("Saved student have id: "+tempStudent.getId());
	}
}
