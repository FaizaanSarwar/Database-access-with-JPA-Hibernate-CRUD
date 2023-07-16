package com.example.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> 
		createStudent(studentDAO);
		//createMultipleStudents(studentDAO);
		//findStudent(studentDAO);
		//queryForStudents(studentDAO);
		//queryForStudentsByLastName(studentDAO);
		//updateStudent(studentDAO);
		//deleteStudent(studentDAO);
		//deleteAllStudents(studentDAO);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("No. of row deleted : " +numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		
		int id = 4;
		System.out.println("Deleting the student with id : " +id);
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id : primary key
		int id = 1;
		System.out.println("Getting studentDAO with id : " +id);
		Student theStudent = studentDAO.findById(id);
		
		//change first name to "Faizaan"
		System.out.println("Updating Student...");
		theStudent.setFirstName("Faizaan");
		
		//update the student
		studentDAO.update(theStudent);
		
		//display the student
		System.out.println(theStudent);
		
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get the list of students
		List<Student> theStudents = studentDAO.findByLastName("Sarwar");
		
		//display the list of students
		for(Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		
		//get the list of students
		List<Student> tempStudent = studentDAO.findAll();
		
		//display list of students
		for(Student student : tempStudent) {
			System.out.println(student);
		}
	}

	private void findStudent(StudentDAO studentDAO) {
		
		//create student the object 
		System.out.println("Creating new student object...");
		Student student = new Student("Md", "Safiullah", "safiullah@gmail.com"); 
		
		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student);
				
		//display the id of saved student
		int id = student.getId();
		System.out.println("Saved student generated id : " + id);
		
		//retrieve student based on id : primary key
		System.out.println("Retreiving student of id : " + id);
		Student theStudent = studentDAO.findById(id);
		
		//display the student
		System.out.println(theStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		
		//create student the object 
		System.out.println("Creating 3 student object...");
		Student student1 = new Student("Md", "Ehtesham", "ehtesham@gmail.com"); 
		Student student2 = new Student("Danish", "Iqbal", "danish@gmail.com"); 
		Student student3= new Student("Anish", "Sheikh", "anish@gmail.com"); 
				
		//save the student object
		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		
		//create student the object 
		System.out.println("Creating new student object...");
		Student student = new Student("Faizaan", "Sarwar", "kfaizaan@gmail.com"); 
		
		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student);
		
		//display the id of saved student
		System.out.println("Saved student generated id : " + student.getId());
		
	}
}
