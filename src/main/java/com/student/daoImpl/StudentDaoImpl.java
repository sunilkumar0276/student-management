package com.student.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.entity.Student;
import com.student.handler.RecordExistsException;
import com.student.handler.RecordNotFoundException;
import com.student.handler.UserResponse;
import com.student.repository.StudentDao;
import com.student.repository.StudentRepository;

@Service
public class StudentDaoImpl implements StudentDao {

	 @Autowired 
private StudentRepository studentRepository;
	@Override
	public Student addNewStudent(Student student) throws RecordExistsException {
	Optional<Student> studentDb=	studentRepository.findStudentByEmail(student.getEmail());
		if(studentDb.isPresent())
		{
		throw new RecordExistsException(" Student already exists with email "+ student.getEmail()+" and id .."+studentDb.get().getId());
		}
		return	studentRepository.save(student);
		//return null;
	}

	@Override
	public Student editStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student fetchStudentById(int id) throws RecordNotFoundException{
		Optional<Student> studentDb=	studentRepository.findById(id);
		System.out.println(studentDb);
		if(studentDb.isPresent())
		{
			return studentDb.get();
		
		}
		throw new RecordNotFoundException(" Failed to fetch student Details");	
	}

	@Override
	public List<Student> fetchStudentList(int paginationNumber) {
		
		return	studentRepository.fetchStudentList(PageRequest.of(paginationNumber,10,Direction.ASC,"name"));
		
	}
@Override
public UserResponse deleteStudentDetails(int id) throws RecordNotFoundException {
	
	Optional<Student> studentDb=	studentRepository.findById(id);
	if(studentDb.isPresent()) {
		studentRepository.deleteById(id);
		UserResponse response= new UserResponse();
		response.setMessage("Student Record deleted");
		return response;
	}
	throw new RecordNotFoundException(" Failed to fetch student Details");
}

@Override
@Transactional
public UserResponse updateStudentDetails(Student student) throws RecordNotFoundException {
	
	UserResponse response= new UserResponse();
int updatedCount=	studentRepository.updateStudentAddressById(student.getAddress(),student.getId());
if(updatedCount>0) {

	response.setMessage("Student Record updated");
	return response;
}
throw new RecordNotFoundException(" Failed to fetch student Details");
}
}
