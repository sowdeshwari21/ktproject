package com.ktp.Ktproject.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String phone;
	private String college;
	private String branch;
	private String yop;
	private String state;
	private String gender;
	private String cgpa;
	
	@OneToMany(mappedBy="student")
	@JsonIgnore
	private List<Enrollment> enrollements;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYop() {
		return yop;
	}

	public void setYop(String yop) {
		this.yop = yop;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	
	

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", college="
				+ college + ", branch=" + branch + ", yop=" + yop + ", state=" + state + ", gender=" + gender
				+ ", cgpa=" + cgpa + "]";
	}

	public List<Enrollment> getEnrollements() {
		return enrollements;
	}

	public void setEnrollements(List<Enrollment> enrollements) {
		this.enrollements = enrollements;
	}
	
	

}
