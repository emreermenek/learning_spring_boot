package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findByLastName("Ermenek");
		//display the list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//	get a list of students
		List<Student> students = studentDAO.findAll();
		//	display list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Creating student..");
		Student student = new Student("Rocky", "Balboa", "italianstalion@gmail.com");


		// save the student
		System.out.println("Saving student..");
		studentDAO.save(student);

		// display the id of the saved student
		int id = student.getId();
		System.out.println("Id of the student is : " + id);

		// display the student based on the id: primary key
		System.out.println("Retrieving student with id : " + id);
		Student myStudent = studentDAO.findById(id);

		// display student
		System.out.println("Found student : " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create 3 student object
		System.out.println("Creating 3 student..");
		Student student1 = new Student("Mehmet Agah", "Caylan", "memo@ymail.com");
		Student student2 = new Student("Mert", "Ermenek", "mertovski@yahoo.com");
		Student student3 = new Student("Kabiz", "Yasar", "kabo@email.com");
		// save them
		System.out.println("Saving students..");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// display their ids
		System.out.println("Student1 id : " + student1.getId() + ", " + "Student2 id : " + student2.getId() + ", " +"Student3 id : " + student3.getId() );
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating student..");
		Student student = new Student("Emre", "Ermenek", "emreermenek1234@gmail.com");

		// save the student object
		System.out.println("Saving student..");
		studentDAO.save(student);

		// display the id of saved student
		System.out.println("Saved student id : " + student.getId());

	}
}
