package com.ktp.Ktproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktp.Ktproject.entity.Payment;
import com.ktp.Ktproject.repo.PaymentRepo;

@Repository
public class PaymentDao {
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	public Payment save(Payment p) {
		return paymentRepo.save(p);
	}
	
	public List<Payment> findAll(){
		return paymentRepo.findAll();
	}
	
	public Payment findById(int id) {
		return paymentRepo.findById(id).orElse(null);
	}
	
	public void delete(int id) {
		paymentRepo.deleteById(id);
	}

}
