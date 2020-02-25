package com.student.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.entity.Student;
import com.student.handler.RecordExistsException;
import com.student.handler.RecordNotFoundException;
import com.student.handler.UserResponse;

@Repository
public interface StudentDao {

	
	Student addNewStudent(Student student) throws RecordExistsException;
	Student editStudentDetails(Student student);
	Student fetchStudentById(int id) throws RecordNotFoundException;
	List<Student> fetchStudentList(int paginationNumber);
	
	UserResponse deleteStudentDetails(int id) throws RecordNotFoundException;
	
	UserResponse updateStudentDetails(Student student) throws RecordNotFoundException;
	
}
