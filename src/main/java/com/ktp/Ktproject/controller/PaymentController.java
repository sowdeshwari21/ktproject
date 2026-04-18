package com.ktp.Ktproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Payment;
import com.ktp.Ktproject.entity.Students;
import com.ktp.Ktproject.service.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	
	 @PostMapping()
	 public ResponseEntity<ResponseStructure<Payment>> addPayment(@RequestBody Payment pay){
		 return service.savePayment(pay);
	 }

	 @GetMapping
	 public ResponseEntity<ResponseStructure<List<Payment>>> getAllPayment(){
		 return service.getAllPayments();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<ResponseStructure<Payment>> getById(@PathVariable int id){
		 return service.getPaymentById(id);
	 }
	 
	 
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<ResponseStructure<Payment>> update(@PathVariable int id,@RequestBody Payment payment){
		 return service.updatePayment(id, payment);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<ResponseStructure<Payment>> delete(@PathVariable int id){
		 return service.deletePayment(id);
	 }
	 
	 
	 
}
