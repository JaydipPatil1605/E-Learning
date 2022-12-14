package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.ResourceNotFoundException;
import com.app.pojo.Admin;
import com.app.pojo.Mentor;
import com.app.pojo.Student;
import com.app.pojo.User;
import com.app.respository.AdminRepository;
import com.app.respository.MentorRepository;
import com.app.respository.StudentRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Override
	public Object authenticateUser(User user) {
		
		//get user's fields from the user object
		String role = user.getUserRole();
		String email = user.getUserEmail();
		String password = user.getUserPassword();
		
		//checking the role of user(admin)
		if(role.equals("admin")) {
			
			//if role is admin : save it in the asmin object
			Admin admin = adminRepository.findByEmailAndPassword(email, password);
			
			//check if admin exists
			if(admin != null)
				return admin;
			else
				
				//if admin does not exists : throw exception
				throw new ResourceNotFoundException("Wrong Credentials for Admin!");
		}
		
		//checking the role of user (student)
		if(role.equals("student")) {
			
			//if the role is student : save it in student object
			Student student = studentRepository.findByEmailAndPassword(email, password);
			
			//check if student exists
			if(student != null)
				return student;
			else
				
				//if student does not exists : throw exception
				throw new ResourceNotFoundException("Wrong Credentials for Student!");
		}
		
		//checking the role of user (mentor)
		if(role.equals("mentor")) {
			
			//if the role is mentor : save it in the mentor object
			Mentor mentor = mentorRepository.findByEmailAndPassword(email, password);
			
			//check if mentor exists
			if(mentor != null)
				return mentor;
			else
				
				//if mentor does not exists : throw exception
				throw new ResourceNotFoundException("Wrong Credentials for Mentor!");
		}
		else
			
			//if user does not exists : throw exception
			throw new ResourceNotFoundException("User does not exists!");
	}

}
