package com.ktp.Ktproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktp.Ktproject.entity.Students;
import com.ktp.Ktproject.repo.StudentRepo;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepo studentRepo;
	
	public Students save(Students stu) {
		return studentRepo.save(stu);
	}
	
	public List<Students> findAll(){
		return studentRepo.findAll();
	}

	public Students findById(int id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public void delete(int id) {
		studentRepo.deleteById(id);
	}
}
