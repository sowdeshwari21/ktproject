package com.ktp.Ktproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ktp.Ktproject.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
