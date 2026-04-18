package com.ktp.Ktproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Enrollment;
import com.ktp.Ktproject.service.EnrollmentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/enrollments")
public class EnrollmentController {
	@Autowired
	private EnrollmentService service;
	
	
	 @PostMapping
	 public ResponseEntity<ResponseStructure<Enrollment>> save(@RequestBody Enrollment e) {
	        return service.save(e);
	    }
	   
	    @GetMapping
	    public ResponseEntity<ResponseStructure<List<Enrollment>>> getAll() {
	        return service.getAll();
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<ResponseStructure<Enrollment>> getById(@PathVariable int id) {
	        return service.getById(id);
	    }
	    

	    @GetMapping("/student/{id}")
	    public ResponseEntity<ResponseStructure<List<Enrollment>>> getByStudent(@PathVariable int id) {
	        return service.getByStudent(id);
	    }
	    
	    @GetMapping("/course/{id}")
	    public ResponseEntity<ResponseStructure<List<Enrollment>>> getByCourse(@PathVariable int id) {
	        return service.getByCourse(id);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseStructure<String>> delete(@PathVariable int id) {
	        return service.delete(id);
	    }


}
