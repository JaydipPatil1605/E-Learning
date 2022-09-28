package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Course;
import com.app.service.IAdminService;
import com.app.service.ICourseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private ICourseService courseService;
	@Autowired
	private IAdminService adminService;
	
	//to add new course
	@PostMapping
	public ResponseEntity<Course> addCourse(@RequestBody Course newCourse) {
		return ResponseEntity.ok(courseService.addNewCourse(newCourse));
	}

	
	//to get course by id
	@GetMapping("/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable int courseId){
		return ResponseEntity.ok(courseService.getCourseById(courseId));
	}

	
	//to get all courses
	@GetMapping
	public ResponseEntity<?> getAllCourses(){
		return ResponseEntity.ok(courseService.getAllCourses());
	}

//	@PutMapping("/{courseId}/{videoLink}")
//	public ResponseEntity<?> addLink(@PathVariable int courseId,@PathVariable String videoLink){
//		Course course=courseService.getCourseById(courseId);
//		course.setVideoLink(videoLink);
//		courseService.addNewCourse(course);
//		return new ResponseEntity<>("Link added successfully",HttpStatus.OK);
//		
//	}
	//to delete course by id
	@RequestMapping(value = "/{courseId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCourseById(@PathVariable int courseId){
		return ResponseEntity.ok(courseService.deleteById(courseId));
	}

	
	//to update course
	@PutMapping("/{courseId}")
	public ResponseEntity<?> updateCourse(@PathVariable int courseId, @RequestBody Course updatedCourse){
		return ResponseEntity.ok(courseService.updateCourse(courseId, updatedCourse));
	}

	// get course details by studentId
	@GetMapping("/studentcourse/{studentId}")
	public ResponseEntity<?> getCourseByStudentId(@PathVariable int studentId){
		return ResponseEntity.ok(courseService.getCourseByStudentId(studentId));
	}

	// get course details by mentorId
	@GetMapping("/mentorcourse/{mentorId}")
	public ResponseEntity<?> getCourseByMentorId(@PathVariable int mentorId){
		return ResponseEntity.ok(courseService.getCourseByMentorId(mentorId));
	}
}
