package com.ktp.Ktproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ktp.Ktproject.dao.StudentDao;
import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Students;

@Service
public class StudentService {
	@Autowired
	private  StudentDao studentdao;
	
	public  ResponseEntity<ResponseStructure<Students>> saveStudent(Students student){
		ResponseStructure<Students> res=new ResponseStructure<>();
		if(student.getName()==null || student.getName().isBlank()){
			throw new IllegalArgumentException("Name Cannot be empty");
		}
		 if (student.getEmail() == null || student.getEmail().isBlank()) {
	            throw new IllegalArgumentException("Email cannot be empty");
	        }
	        if (student.getPhone() == null || student.getPhone().isBlank()) {
	            throw new IllegalArgumentException("Phone cannot be empty");
	        }
	        
	        res.setStatuscode(HttpStatus.CREATED.value());
	        res.setMessage("Student saved successfully");
	        res.setData(studentdao.save(student));

	        return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Students>>> getAllStudents() {

        ResponseStructure<List<Students>> res = new ResponseStructure<>();
        List<Students> list = studentdao.findAll();

        if (!list.isEmpty()) {
            res.setStatuscode(HttpStatus.OK.value());
            res.setMessage("Students fetched successfully");
            res.setData(list);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            res.setStatuscode(HttpStatus.NOT_FOUND.value());
            res.setMessage("No students found");
            res.setData(null);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }

	 public ResponseEntity<ResponseStructure<Students>> getById(int id) {

	        ResponseStructure<Students> res = new ResponseStructure<>();
	        Students student = studentdao.findById(id);

	        if (student != null) {
	            res.setStatuscode(HttpStatus.OK.value());
	            res.setMessage("Student found");
	            res.setData(student);
	            return new ResponseEntity<>(res, HttpStatus.OK);
	        } else {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Student not found");
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        }
	    }
	
	
	 public ResponseEntity<ResponseStructure<Students>> updateStudent(int id, Students student) {

	        ResponseStructure<Students> res = new ResponseStructure<>();
	        Students existing = studentdao.findById(id);

	        if (existing == null) {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Student not found with id " + id);
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        } if (student.getName() != null && !student.getName().isBlank()) {
	            existing.setName(student.getName());
	        }
	        if (student.getEmail() != null && !student.getEmail().isBlank()) {
	            existing.setEmail(student.getEmail());
	        }
	        if (student.getPhone() != null && !student.getPhone().isBlank()) {
	            existing.setPhone(student.getPhone());
	        }
	        if (student.getCollege() != null) {
	            existing.setCollege(student.getCollege());
	        }
	        if (student.getBranch() != null) {
	            existing.setBranch(student.getBranch());
	        }
	        if (student.getYop() != null) {
	            existing.setYop(student.getYop());
	        }
	        if (student.getState() != null) {
	            existing.setState(student.getState());
	        }
	        if (student.getGender() != null) {
	            existing.setGender(student.getGender());
	        }
	        if (student.getCgpa() != null) {
	            existing.setCgpa(student.getCgpa());
	        }
	        Students updated = studentdao.save(existing);

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Student updated successfully");
	        res.setData(updated);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	 }
	 
	 
	 public ResponseEntity<ResponseStructure<Students>> deleteStudent(int id) {

	        ResponseStructure<Students> res = new ResponseStructure<>();
	        Students existing = studentdao.findById(id);

	        if (existing == null) {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Student not found with id " + id);
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        }  studentdao.delete(id);

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Student deleted successfully");
	        res.setData(existing);

	        return new ResponseEntity<>(res, HttpStatus.OK);
}
}