package com.ktp.Ktproject.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int enrid;
	private String startdate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Students student;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Courses course;
	
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainers trainer;
	public int getEnrid() {
		return enrid;
	}
	public void setEnrid(int enrid) {
		this.enrid = enrid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Enrollment [enrid=" + enrid + ", startdate=" + startdate + ", status=" + status + "]";
	}
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	public Trainers getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainers trainer) {
		this.trainer = trainer;
	}
	
	
	

	

}
