package com.ktp.Ktproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ktp.Ktproject.dao.EnrollmentDao;
import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Enrollment;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentDao dao;
	
	  public ResponseEntity<ResponseStructure<Enrollment>> save(Enrollment e) {

	        ResponseStructure<Enrollment> res = new ResponseStructure<>();

	        res.setStatuscode(HttpStatus.CREATED.value());
	        res.setMessage("Enrollment created successfully");
	        res.setData(dao.save(e));

	        return new ResponseEntity<>(res, HttpStatus.CREATED);
	    }

	  public ResponseEntity<ResponseStructure<List<Enrollment>>> getAll() {

	        ResponseStructure<List<Enrollment>> res = new ResponseStructure<>();

	        List<Enrollment> list = dao.findAll();

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("All enrollments fetched");
	        res.setData(list);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	  
	  public ResponseEntity<ResponseStructure<Enrollment>> getById(int id) {

	        ResponseStructure<Enrollment> res = new ResponseStructure<>();

	        Enrollment e = dao.findById(id);

	        if (e != null) {
	            res.setStatuscode(HttpStatus.OK.value());
	            res.setMessage("Enrollment found");
	            res.setData(e);
	            return new ResponseEntity<>(res, HttpStatus.OK);
	        } else {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Enrollment not found");
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        }
	  }
	  
	  public ResponseEntity<ResponseStructure<List<Enrollment>>> getByStudent(int id) {

	        ResponseStructure<List<Enrollment>> res = new ResponseStructure<>();

	        List<Enrollment> list = dao.findByStudent(id);

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Student enrollments fetched");
	        res.setData(list);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	  

	    public ResponseEntity<ResponseStructure<List<Enrollment>>> getByCourse(int id) {

	        ResponseStructure<List<Enrollment>> res = new ResponseStructure<>();

	        List<Enrollment> list = dao.findByCourse(id);

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Course enrollments fetched");
	        res.setData(list);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	    public ResponseEntity<ResponseStructure<String>> delete(int id) {

	        ResponseStructure<String> res = new ResponseStructure<>();

	        dao.delete(id);

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Enrollment deleted");
	        res.setData("Deleted");

	        return new ResponseEntity<>(res, HttpStatus.OK);
	    }


}
