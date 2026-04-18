package com.kt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.kt.Student;

public class studentdao {

	EntityManagerFactory fac=Persistence.createEntityManagerFactory("data");
	EntityManager man=fac.createEntityManager();
	
	
	


	public Student saveStudent(Student s) {
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		man.persist(s);
		tran.commit();
		
		return s;
	}
	
}
