package com.ktp.Ktproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ktp.Ktproject.entity.Students;

public interface StudentRepo extends JpaRepository<Students, Integer>{

}
