package com.ktp.Ktproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktp.Ktproject.entity.Enrollment;
import com.ktp.Ktproject.repo.EnrollmentRepo;

@Repository
public class EnrollmentDao {
	
	@Autowired
	private EnrollmentRepo enrollmentRepo;
	
	public Enrollment save(Enrollment e) {
		return enrollmentRepo.save(e);
	}
	
	public List<Enrollment> findAll(){
		return enrollmentRepo.findAll();
		
	}

	public Enrollment findById(int id) {
		return enrollmentRepo.findById(id).orElse(null);
	}
	
	public List<Enrollment> findByStudent(int id){
		return enrollmentRepo.findByStudentId(id);
	}
	
	public List<Enrollment> findByCourse(int id){
		return enrollmentRepo.findByCourseId(id);
	}
	
	public void delete(int id) {
		enrollmentRepo.deleteById(id);
	}
}
