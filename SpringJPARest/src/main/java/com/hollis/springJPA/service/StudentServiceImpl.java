package com.hollis.springJPA.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollis.springJPA.entity.Student;
import com.hollis.springJPA.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student s)
	{
		return studentRepository.save(s);
	}
	
	@Override
	public List<Student> studentsList()
	{
		return (List<Student>)studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student s, long id)
	{
		Student dbStudent = studentRepository.findById(id).get();
		dbStudent.setFirstName(s.getFirstName());
		dbStudent.setEmail(s.getEmail());
		dbStudent.setGender(s.getGender());
		dbStudent.setCourses(s.getCourses());
		return studentRepository.save(dbStudent);
	}

	@Override
	public void deleteStudentById(long id)
	{
		studentRepository.deleteById(id);
	}
}