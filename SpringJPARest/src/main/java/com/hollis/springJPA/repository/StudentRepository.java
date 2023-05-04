package com.hollis.springJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hollis.springJPA.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
	
}