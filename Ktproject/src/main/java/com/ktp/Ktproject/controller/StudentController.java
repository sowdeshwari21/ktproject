package com.ktp.Ktproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Students;
import com.ktp.Ktproject.service.StudentService;

@RestController
@RequestMapping("/api/students")

public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	 @PostMapping()
	 public ResponseEntity<ResponseStructure<Students>> addStudent(@RequestBody Students stu){
		 return studentservice.saveStudent(stu);
	 }
	
	 
	 @GetMapping
	 public ResponseEntity<ResponseStructure<List<Students>>> getAllStudents(){
		  return studentservice.getAllStudents();
	  }
	 
	 @GetMapping("/{id}")
	  public ResponseEntity<ResponseStructure<Students>> getById(@PathVariable int id){
		  return studentservice.getById(id);
	  }

	 @PatchMapping("/update/{id}")
		public ResponseEntity<ResponseStructure<Students>> updateStudent(@PathVariable Integer id,@RequestBody Students students){
			return studentservice.updateStudent(id, students);
		}
	 @DeleteMapping("/{id}")
	  public ResponseEntity<ResponseStructure<Students>> deleteStudent(@PathVariable Integer id){
		  return studentservice.deleteStudent(id);
	  }
}
