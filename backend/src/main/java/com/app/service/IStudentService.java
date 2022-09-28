package com.app.service;

import java.util.List;

import com.app.dto.StudentAddressDTO;
import com.app.pojo.Address;
import com.app.pojo.Mentor;
import com.app.pojo.Student;

public interface IStudentService {

	// to register new Student 
	public String registerStudent(int courseId, StudentAddressDTO studentAddressDto);

	// to get Student details by Id
	public Student getStudentById(int studentId);

	// to get all Students
	public List<Student>getAllStudents();

	// to delete Student by Student Id
	public String deleteStudentById(int studentId);

	// to update the course in table
	public String updateStudent(int studentId, Student newStudent);

	//assign mentor to student and get list of assigned mentors in return
	public Mentor assignMentorToStudent(int studentId);
	
	//update marks of student (done by mentor)
	public String updateMarks(int studentId, int newMarks);

	Address getAddressByStudentId(int studentId);

	Mentor getMentorByStudentId(int studentId);

	Address getAssignedMentorsAddressByStudentId(int studentId);
}
