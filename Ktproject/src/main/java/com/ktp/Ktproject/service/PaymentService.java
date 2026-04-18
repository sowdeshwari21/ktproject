package com.ktp.Ktproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ktp.Ktproject.dao.PaymentDao;
import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentDao dao;
	
	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment){
		ResponseStructure<Payment> res=new ResponseStructure<>();
		
		if(payment.getAmount()<=0) {
			throw new IllegalArgumentException("Amount must be greater than 0");
		}
		if(payment.getPaymentdate()==null||payment.getPaymentdate().isBlank()) {
			throw new IllegalArgumentException("Payment date cannot be empty");
		}
		if(payment.getStatus()==null||payment.getStatus().isBlank()) {
			throw new IllegalArgumentException("Status cannot be empty");
		}
		res.setStatuscode(HttpStatus.CREATED.value());
		res.setMessage("Payment saved successfully");
		res.setData(dao.save(payment));
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<List<Payment>>> getAllPayments() {

        ResponseStructure<List<Payment>> res = new ResponseStructure<>();
        List<Payment> list = dao.findAll();

        if (!list.isEmpty()) {
            res.setStatuscode(HttpStatus.OK.value());
            res.setMessage("Payments fetched successfully");
            res.setData(list);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            res.setStatuscode(HttpStatus.NOT_FOUND.value());
            res.setMessage("No Payments found");
            res.setData(null);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }
	
	public ResponseEntity<ResponseStructure<Payment>> getPaymentById(int id) {

        ResponseStructure<Payment> res = new ResponseStructure<>();
        Payment payment = dao.findById(id);

        if (payment != null) {
            res.setStatuscode(HttpStatus.OK.value());
            res.setMessage("Payment found");
            res.setData(payment);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            res.setStatuscode(HttpStatus.NOT_FOUND.value());
            res.setMessage("Payment not found");
            res.setData(null);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }
	
	 public ResponseEntity<ResponseStructure<Payment>> updatePayment(int id, Payment payment) {

	        ResponseStructure<Payment> res = new ResponseStructure<>();
	        Payment existing = dao.findById(id);

	        if (existing == null) {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Payment not found with id " + id);
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        }
	        if (payment.getAmount() > 0) {
	            existing.setAmount(payment.getAmount());
	        }
	        if (payment.getPaymentdate()!=null && !payment.getPaymentdate().isBlank()) {
	            existing.setPaymentdate(payment.getPaymentdate());
	        }
	        if (payment.getStatus() != null && !payment.getStatus().isBlank()) {
	            existing.setStatus(payment.getStatus());
	        }
	        if (payment.getEnrollment() != null) {
	            existing.setEnrollment(payment.getEnrollment());
	        }

	        Payment updated = dao.save(existing);
	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Payment updated successfully");
	        res.setData(updated);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	    }

	 public ResponseEntity<ResponseStructure<Payment>> deletePayment(int id) {

	        ResponseStructure<Payment> res = new ResponseStructure<>();
	        Payment existing = dao.findById(id);

	        if (existing == null) {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Payment not found with id " + id);
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        }
	        dao.delete(id);

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Payment deleted successfully");
	        res.setData(existing);

	        return new ResponseEntity<>(res, HttpStatus.OK);
}
}