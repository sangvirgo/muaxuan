package com.sang.thesecondapplication;

import com.sang.thesecondapplication.dao.StudentDAO;
import com.sang.thesecondapplication.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("The number of students were deteled: "+studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting student with id 7");
		Student student = studentDAO.findById(7);
		if (student != null) {
			studentDAO.deleteById(7);
			System.out.println("Deleted student with id 7");
		} else {
			System.out.println("Student with id 7 not found.");
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Getting the student with id 2");
		Student temp=studentDAO.findById(2);

		System.out.println("Updating student...");
		temp.setFirstName("Sang");
		studentDAO.updateTheStudent(temp);

		System.out.println("Updated student: "+studentDAO.findById(2));

		System.out.println("Done" + temp);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> listStudent=studentDAO.findByLastName("Doe");
		listStudent.forEach(System.out::println);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> listStudent=studentDAO.findAll();
		listStudent.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		Student result=studentDAO.findById(1);
		if(result!=null) {
			System.out.println("Student found: "+result);
		} else {
			System.out.println("Student not found");
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1=new Student("Han", "Phan", "hihi@gmai.com");
		Student student2 = new Student("John", "Doe", "john.doe@example.com");
		Student student3 = new Student("Jane", "Smith", "jane.smith@example.com");
		Student student4 = new Student("Alice", "Johnson", "alice.johnson@example.com");
		Student student5 = new Student("Bob", "Brown", "bob.brown@example.com");
		Student student6 = new Student("Charlie", "Davis", "charlie.davis@example.com");

		studentDAO.save(student4);
		studentDAO.save(student5);
		studentDAO.save(student6);
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
