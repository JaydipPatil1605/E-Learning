package com.app.service;

import java.util.List;

import com.app.dto.MentorAddressDTO;
import com.app.pojo.Address;
import com.app.pojo.Mentor; 

public interface IMentorService {
	//to get list of students assigned to mentorId
	public List<?> getAssignedStudents(int mentorId);

	//to update marks of student
	public String updateMarksOfStudent(int studentId, float studentsMarks);

	//upate mentor
	public Mentor updateMentor(int mentorId, Mentor newMentor);

	//to get mentor by id
	public Mentor getMentorById(int mentorId);

	//to delete mentor
	public String deleteMentorById(int mentorId);

	//to register mentor with address and course
	public String registerMentor(int courseId, MentorAddressDTO mentorAddressDto);

	Address getAddressByMentorId(int mentorId);
	
	List<Mentor> getAllMentors();
}
