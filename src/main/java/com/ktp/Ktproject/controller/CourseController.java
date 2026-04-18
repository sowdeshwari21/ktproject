package com.ktp.Ktproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktp.Ktproject.dto.ResponseStructure;
import com.ktp.Ktproject.entity.Courses;
import com.ktp.Ktproject.service.CoursesService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/courses")
public class CourseController {
	
	@Autowired
	private CoursesService courseService;
	
	@PostMapping
    public ResponseEntity<ResponseStructure<Courses>> saveCourse(@RequestBody Courses course) {
        return courseService.saveCourse(course);
    }

	 @GetMapping
	    public ResponseEntity<ResponseStructure<List<Courses>>> getAllCourses() {
	        return courseService.getAllCourse();
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<ResponseStructure<Courses>> getCourseById(@PathVariable int id) {
	        return courseService.getById(id);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<ResponseStructure<Courses>> updateCourse(
	            @PathVariable int id,
	            @RequestBody Courses course) {
	        return courseService.updateCourse(id, course);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseStructure<String>> deleteCourse(@PathVariable int id) {
	        return courseService.deleteCourse(id);
	    }
}
