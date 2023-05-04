package com.hollis.springJPA;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.hollis.springJPA.entity.Student;
import com.hollis.springJPA.service.JsonStudent;


@SpringBootApplication
@EntityScan
public class SpringJPARest {

	public static void main(String[] args) {
		JsonStudent initialDatabase = new JsonStudent();
		try{initialDatabase.populateStudents("https://hccs-advancejava.s3.amazonaws.com/student_course.json");}
		catch(Exception e) {System.out.println("JSON parse failed.");}
		ArrayList<Student> students = initialDatabase.getStudents();
		for(int x = 0; x < students.size(); x++)
		{
			
		}
		SpringApplication.run(SpringJPARest.class, args);
	}
}
