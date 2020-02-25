package com.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.student.entity.Student;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query("SELECT u FROM Student u WHERE u.email = ?1")
	Optional<Student> findStudentByEmail(String email);
	
	@Query(  value = "SELECT * FROM Student",nativeQuery = true)
	List<Student> fetchStudentList(Pageable pageable);
	

	@Modifying
	@Query("update Student u set u.address = :address where u.id = :id")
	int updateStudentAddressById(@Param("address")String address, @Param("id")int id);
	
}