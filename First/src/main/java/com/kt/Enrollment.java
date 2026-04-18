package com.kt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrid;
	private int stuid;
	private int cid;
	private int tid;
	private String startdate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="student")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="course")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="trainer")
	private Trainer trainer;
	
	public int getEnrid() {
		return enrid;
	}
	public void setEnrid(int enrid) {
		this.enrid = enrid;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
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
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "Enrollment [enrid=" + enrid + ", stuid=" + stuid + ", cid=" + cid + ", tid=" + tid + ", startdate="
				+ startdate + ", status=" + status + "]";
	}
	
	
	
	
}
