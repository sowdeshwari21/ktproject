package com.ktp.Ktproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ktp.Ktproject.entity.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer>{
	
	List<Enrollment> findByStudentId(int id);
	
	List<Enrollment> findByCourseId(int id);

}
