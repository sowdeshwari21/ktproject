
package com.ktp.Ktproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktp.Ktproject.entity.Employee;
import com.ktp.Ktproject.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepo repo;

	public Employee save(Employee e) {
		return repo.save(e);
	}
	
	public List<Employee> findAll(){
		return repo.findAll();
	}
	
	public Employee findById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
