package com.hollis.springJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hollis.springJPA.entity.Student;
import com.hollis.springJPA.service.StudentService;

@RestController
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public Student saveStudent(Student s)
	{
		return studentService.saveStudent(s);
	}
	@GetMapping("/students")
	public List<Student> studentsList()
	{
		return studentService.studentsList();
	}
	@PutMapping("/students/{id}")
	public Student updateStudent(Student s, long id)
	{
		return studentService.updateStudent(s, id);
	}
	@DeleteMapping("/students/{id}")
	public void deleteStudentById(long id)
	{
		studentService.deleteStudentById(id);
	}
}