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
import com.ktp.Ktproject.entity.Trainers;
import com.ktp.Ktproject.service.TrainerService;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {
	
  @Autowired
  private TrainerService trainerService;
  
  
  @PostMapping()
  public ResponseEntity<ResponseStructure<Trainers>> addTrainers(@RequestBody Trainers trainer){
	  return trainerService.saveTrainers(trainer);
  }
  
  @GetMapping
  public ResponseEntity<ResponseStructure<List<Trainers>>> getAllTrainers(){
	  return trainerService.saveAll();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<ResponseStructure<Trainers>> getById(@PathVariable int id){
	  return trainerService.getById(id);
  }
  
  @PatchMapping("/update/{id}")
  public ResponseEntity<ResponseStructure<Trainers>> updateTrainer(@PathVariable int id,@RequestBody Trainers trainer){
	  return trainerService.updateTrainer(id, trainer);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseStructure<Trainers>> deleteTrainer(@PathVariable int id){
	  return trainerService.deleteTrainer(id);
  }

}
