package com.ktp.Ktproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ktp.Ktproject.dao.EmployeeDao;
import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao dao;
	
	public ResponseEntity<ResponseStructure<Employee>> save(Employee e){
		ResponseStructure<Employee> res=new ResponseStructure<>();
		
		if(e.getName()==null||e.getName().isBlank()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		 if (e.getEmail() == null || e.getEmail().isBlank()) {
	            throw new IllegalArgumentException("Email cannot be empty");
	        }
	        if (e.getPhone() == null || e.getPhone().isBlank()) {
	            throw new IllegalArgumentException("Phone cannot be empty");
	        }
	        res.setStatuscode(HttpStatus.CREATED.value());
	        res.setMessage("Employee saved successfully");
	        res.setData(dao.save(e));
	        return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getAll() {

        ResponseStructure<List<Employee>> res = new ResponseStructure<>();
        List<Employee> list = dao.findAll();

        if (!list.isEmpty()) {
            res.setStatuscode(HttpStatus.OK.value());
            res.setMessage("Employees fetched successfully");
            res.setData(list);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            res.setStatuscode(HttpStatus.NOT_FOUND.value());
            res.setMessage("No Employees found");
            res.setData(null);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }
	
	public ResponseEntity<ResponseStructure<Employee>> getById(int id) {

        ResponseStructure<Employee> res = new ResponseStructure<>();
        Employee e = dao.findById(id);

        if (e != null) {
            res.setStatuscode(HttpStatus.OK.value());
            res.setMessage("Employee found");
            res.setData(e);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            res.setStatuscode(HttpStatus.NOT_FOUND.value());
            res.setMessage("Employee not found");
            res.setData(null);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }
	
	public ResponseEntity<ResponseStructure<Employee>> update(int id, Employee newData) {

        ResponseStructure<Employee> res = new ResponseStructure<>();
        Employee existing = dao.findById(id);

        if (existing == null) {
            res.setStatuscode(HttpStatus.NOT_FOUND.value());
            res.setMessage("Employee not found with id " + id);
            res.setData(null);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        if (newData.getName() != null && !newData.getName().isBlank()) {
            existing.setName(newData.getName());
        }
        if (newData.getEmail() != null && !newData.getEmail().isBlank()) {
            existing.setEmail(newData.getEmail());
        }
        if (newData.getPhone() != null && !newData.getPhone().isBlank()) {
            existing.setPhone(newData.getPhone());
        }
        if (newData.getRole() != null && !newData.getRole().isBlank()) {
            existing.setRole(newData.getRole());
        }
        if (newData.getExperience() != 0) {
            existing.setExperience(newData.getExperience());
        }
        Employee updated = dao.save(existing);

        res.setStatuscode(HttpStatus.OK.value());
        res.setMessage("Employee updated successfully");
        res.setData(updated);

        return new ResponseEntity<>(res, HttpStatus.OK);

	}
	
	 public ResponseEntity<ResponseStructure<Employee>> delete(int id) {

	        ResponseStructure<Employee> res = new ResponseStructure<>();
	        Employee existing = dao.findById(id);

	        if (existing == null) {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Employee not found with id " + id);
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        }

	        dao.delete(id);
	        
	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Employee deleted successfully");
	        res.setData(existing);

	        return new ResponseEntity<>(res, HttpStatus.OK);
}
}