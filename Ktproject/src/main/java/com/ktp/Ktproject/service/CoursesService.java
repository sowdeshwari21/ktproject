package com.ktp.Ktproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ktp.Ktproject.dao.CoursesDao;
import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Courses;
import com.ktp.Ktproject.entity.Students;

@Service
public class CoursesService {
	
	@Autowired
	private CoursesDao courseDao;
	
	public  ResponseEntity<ResponseStructure<Courses>> saveCourse(Courses courses){
		ResponseStructure<Courses> res=new ResponseStructure<>();
		res.setStatuscode(HttpStatus.CREATED.value());
		res.setMessage("Course saved successfully");
	   res.setData(courseDao.save(courses));
	   return new ResponseEntity<>(res,HttpStatus.CREATED);
	   
	   
	}
		
	public ResponseEntity<ResponseStructure<List<Courses>>> getAllCourse() {

        ResponseStructure<List<Courses>> res = new ResponseStructure<>();
        List<Courses> list = courseDao.findAll();

        if (!list.isEmpty()) {
            res.setStatuscode(HttpStatus.OK.value());
            res.setMessage("Courses fetched successfully");
            res.setData(list);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } 
	
        else {
            res.setStatuscode(HttpStatus.NOT_FOUND.value());
            res.setMessage("No course found");
            res.setData(null);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }
	
	public ResponseEntity<ResponseStructure<Courses>> getById(int id) {

        ResponseStructure<Courses> res = new ResponseStructure<>();
       Courses course=courseDao.findById(id);

        if (course != null) {
            res.setStatuscode(HttpStatus.OK.value());
            res.setMessage("course found");
            res.setData(course);
            return new ResponseEntity<>(res, HttpStatus.OK);
}else {
    res.setStatuscode(HttpStatus.NOT_FOUND.value());
    res.setMessage("course not found");
    res.setData(null);
    return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
}
}
	
	 public ResponseEntity<ResponseStructure<Courses>> updateCourse(int id, Courses course) {
	        ResponseStructure<Courses> res = new ResponseStructure<>();

	        Courses existing = courseDao.findById(id);

	        if (existing == null) {
	            res.setStatuscode(HttpStatus.NOT_FOUND.value());
	            res.setMessage("Course not found");
	            res.setData(null);
	            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	        }
	        if (course.getCoursename() != null && !course.getCoursename().isBlank()) {
	            existing.setCoursename(course.getCoursename());
	        }

	        Courses updated = courseDao.save(existing);

	        res.setStatuscode(HttpStatus.OK.value());
	        res.setMessage("Course updated successfully");
	        res.setData(updated);
	        return new ResponseEntity<>(res, HttpStatus.OK);	
}
	 
	 public ResponseEntity<ResponseStructure<String>> deleteCourse(int id) {
	        ResponseStructure<String> res = new ResponseStructure<>();

	        Courses course = courseDao.findById(id);

	        if (course != null) {
	            courseDao.delete(id);
	            res.setStatuscode(HttpStatus.OK.value());
	            res.setMessage("Course deleted successfully");
	            res.setData("Deleted");
	          return new ResponseEntity<>(res, HttpStatus.OK);
     } else {
         res.setStatuscode(HttpStatus.NOT_FOUND.value());
         res.setMessage("Course not found");
         res.setData(null);
         return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
     }
}
}
