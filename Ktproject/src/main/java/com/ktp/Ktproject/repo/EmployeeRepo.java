package com.ktp.Ktproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ktp.Ktproject.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
