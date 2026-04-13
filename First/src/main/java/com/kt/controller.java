package com.kt;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kt.dao.studentdao;
import com.kt.dao.trainerdao;

public class controller {
	static Scanner sc=new Scanner(System.in);
	static studentdao sdao=new studentdao();
	static trainerdao tdao=new trainerdao();
	public static void main(String[] args) {
		
		
		
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("data");
		System.out.println(fac);
		
	 System.out.println("Enter student details");
	 System.out.println("Enter trainer details");
	 System.out.println("Enter course details");
	 
	 int choice=sc.nextInt();
	 sc.nextLine();
	 switch(choice) {
	 case 1:
		 saveStudent();
		 break;
		 
	 case 2:
		 saveTrainer();
		 break;
		 
		 
		 
	 }
		
		
	}
	

	private static void saveTrainer() {
		System.out.println("Enter Trainer Informations"+"1.name +"
				+ "2.email +"
				+ "3.Phone +"
				+ "4.Experience +"
				+ "5.Subject");
		String tnm=sc.nextLine();
		String em=sc.nextLine();
		String ph=sc.nextLine();
		int ex=sc.nextInt();
		sc.nextLine();
		String sub=sc.nextLine();
		
		Trainer t=new Trainer();
		t.setName(tnm);
		t.setEmail(em);
		t.setPhone(ph);
		t.setExperience(ex);
		t.setSubject(sub);
		
		Trainer td=tdao.saveTrainer(t);
		
	}


	private static void saveStudent() {
	System.out.println("Enter student information"
			+ "1.name"
			+ "2.email"
			+"3.phone"
			+"4.college"
			+"5.branch"
			+"6.Year of passedout"
			+ "7.state"
			+ "8.gender"
			+ "9.CGPA");
	
	String nm=sc.nextLine();
	String em=sc.nextLine();
	String ph=sc.nextLine();
	String cl=sc.nextLine();
	String br=sc.nextLine();
	String yop=sc.nextLine();
	String st=sc.nextLine();
	String gn=sc.nextLine();
	String cgpa=sc.nextLine();
	
	Student s=new Student();
	s.setName(nm);
	s.setEmail(em);
	s.setPhone(ph);
	s.setCollege(cl);
	s.setBranch(br);
	s.setYop(yop);
	s.setState(st);
	s.setGender(gn);
	s.setCgpa(cgpa);
	
	Student sdb=sdao.saveStudent(s);
	
		
	}

}
