package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.handler.RecordExistsException;
import com.student.handler.RecordNotFoundException;
import com.student.handler.UserResponse;
import com.student.repository.StudentDao;
import com.student.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	

	 
	 @Autowired
	 private StudentDao studentDao;
	 
	 @PostMapping("/add")
	 public Student addNewStudent(@RequestBody Student student) throws RecordExistsException {
		 return studentDao.addNewStudent(student);
		
	}
	 
	 @PutMapping("/edit")
	 public UserResponse updateStudentDetails(@RequestBody Student student) throws  RecordNotFoundException {
		 return studentDao.updateStudentDetails(student);
		
	}
	 @DeleteMapping("/delete")
	 public UserResponse deleteStudentDetails(@RequestParam int id) throws RecordNotFoundException {
		 return studentDao.deleteStudentDetails(id);
		
	}
	 @GetMapping(path="/all")
	  public @ResponseBody List<Student> fetchStudentList(@RequestParam int paginationNumber) {

	    return studentDao.fetchStudentList(paginationNumber);
	  }
	 
	
	 @GetMapping("/findone")
	 public Student fetchStudentById(@RequestParam int id) throws RecordNotFoundException {
		 
		return studentDao.fetchStudentById(id);
		 
	 }

	
}
