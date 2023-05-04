package com.hollis.springJPA.service;

import java.util.List;

import com.hollis.springJPA.entity.Student;

public interface StudentService
{
	Student saveStudent(Student s);
	List<Student> studentsList();
	Student updateStudent(Student s, long id);
	void deleteStudentById(long id);
}