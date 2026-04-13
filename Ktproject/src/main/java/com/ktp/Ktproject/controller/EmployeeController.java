package com.ktp.Ktproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Employee;
import com.ktp.Ktproject.service.EmployeeService;

@RestController 
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee e){
		return service.save(e);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmp(){
		return service.getAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getById(@PathVariable int id){
		return service.getById(id);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Employee>> update(@PathVariable int id,@RequestBody Employee e){
		return service.update(id, e);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Employee>> delete(@PathVariable int id){
		return service.delete(id);
	}
	
	
	

	
}
