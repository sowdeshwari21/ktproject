package com.kt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.kt.Trainer;

public class trainerdao {
	EntityManagerFactory fac=Persistence.createEntityManagerFactory("data");
	EntityManager man=fac.createEntityManager();
	

	public Trainer saveTrainer(Trainer t) {
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		man.persist(t);
		tran.commit();
		
		return t;
	}

}
