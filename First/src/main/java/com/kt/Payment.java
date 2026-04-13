package com.kt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private int id;
	private int erid;
	private int amount;
	private String paymentdate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="enrollment")
	private Enrollment enrollment;
	
	
	
	public Enrollment getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getErid() {
		return erid;
	}
	public void setErid(int erid) {
		this.erid = erid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", erid=" + erid + ", amount=" + amount + ", paymentdate=" + paymentdate
				+ ", status=" + status + "]";
	}
	
	
	
	

}
