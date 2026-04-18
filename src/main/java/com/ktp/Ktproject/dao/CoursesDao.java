package com.ktp.Ktproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktp.Ktproject.entity.Courses;
import com.ktp.Ktproject.repo.CoursesRepo;

@Repository
public class CoursesDao {
	
	@Autowired
	private CoursesRepo courseRepo;
	
	public Courses save(Courses course) {
		return courseRepo.save(course);
	}
	
	public List<Courses> findAll(){
		return courseRepo.findAll();
	}
	
	public Courses findById(int id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	public void delete(int id) {
		 courseRepo.deleteById(id);
	}

}
