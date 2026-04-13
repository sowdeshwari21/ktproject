package com.ktp.Ktproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktp.Ktproject.entity.Trainers;
import com.ktp.Ktproject.repo.TrainerRepo;

@Repository
public class TrainerDao {
	@Autowired
	private TrainerRepo trainerRepo;
	
	public Trainers save(Trainers trainer) {
		return trainerRepo.save(trainer);
	}
	
	public List<Trainers> findAll(){
		return trainerRepo.findAll();
	}
	
	public Trainers findByid(int id) {
		return trainerRepo.findById(id).orElse(null);
	}
	
	public void delete(int id) {
		trainerRepo.deleteById(id);
	}
	

}
