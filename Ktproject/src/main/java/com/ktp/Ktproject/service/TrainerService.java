package com.ktp.Ktproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ktp.Ktproject.dao.TrainerDao;
import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Students;
import com.ktp.Ktproject.entity.Trainers;
import com.ktp.Ktproject.repo.TrainerRepo;

@Service
public class TrainerService {
	@Autowired
	private TrainerDao trainerDao; 
	
	public ResponseEntity<ResponseStructure<Trainers>> saveTrainers(Trainers trainer){
		ResponseStructure<Trainers> res=new ResponseStructure<>();
		if(trainer.getName()==null||trainer.getName().isBlank()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		if(trainer.getEmail()==null||trainer.getEmail().isBlank()) {
			throw new IllegalArgumentException("Email cannot be Empty");
		}
		if(trainer.getPhone()==null||trainer.getPhone().isBlank()) {
			throw new IllegalArgumentException("Phone cannot be empty");
		}
		res.setStatuscode(HttpStatus.CREATED.value());
		res.setMessage("Trainer saved successfully");
		res.setData(trainerDao.save(trainer));
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}
	

	public ResponseEntity<ResponseStructure<List<Trainers>>> saveAll() {

        ResponseStructure<List<Trainers>> res = new ResponseStructure<>();
        List<Trainers> list = trainerDao.findAll();

        if (!list.isEmpty()) {
            res.setStatuscode(HttpStatus.OK.value());
            res.setMessage("Trainers fetched successfully");
            res.setData(list);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            res.setStatuscode(HttpStatus.NOT_FOUND.value());
            res.setMessage("No Trainers found");
            res.setData(null);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }

	public ResponseEntity<ResponseStructure<Trainers>> getById(int id) {

        ResponseStructure<Trainers> res = new ResponseStructure<>();
        Trainers trainer = trainerDao.findByid(id);

        if (trainer != null) {
            res.setStatuscode(HttpStatus.OK.value());
            res.setMessage("Trainer found");
            res.setData(trainer);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            res.setStatuscode(HttpStatus.NOT_FOUND.value());
            res.setMessage("Trainer not found");
            res.setData(null);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }

	 public ResponseEntity<ResponseStructure<Trainers>> updateTrainer(int id, Trainers trainer) {

	        ResponseStructure<Trainers> res = new ResponseStructure<>();
	        Trainers existing = trainerDao.findByid(id);

	        if (existing == null) {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Trainer not found with id " + id);
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        } if (trainer.getName() != null && !trainer.getName().isBlank()) {
	            existing.setName(trainer.getName());
	        }
	        if (trainer.getEmail() != null && !trainer.getEmail().isBlank()) {
	            existing.setEmail(trainer.getEmail());
	        }
	        if (trainer.getPhone() != null && !trainer.getPhone().isBlank()) {
	            existing.setPhone(trainer.getPhone());
	        }
	        if (trainer.getExperience() != 0) {
	            existing.setExperience(trainer.getExperience());
	        }
	        if (trainer.getSubject()!= null && !trainer.getSubject().isBlank()) {
	            existing.setSubject(trainer.getSubject());
	        }
	        Trainers updated = trainerDao.save(existing);

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Trainer updated successfully");
	        res.setData(updated);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	 }

	 
	 public ResponseEntity<ResponseStructure<Trainers>> deleteTrainer(int id) {

	        ResponseStructure<Trainers> res = new ResponseStructure<>();
	        Trainers existing = trainerDao.findByid(id);

	        if (existing == null) {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Trainer not found with id " + id);
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        }  trainerDao.delete(id);

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Trainer deleted successfully");
	        res.setData(existing);

	        return new ResponseEntity<>(res, HttpStatus.OK);
}
}
