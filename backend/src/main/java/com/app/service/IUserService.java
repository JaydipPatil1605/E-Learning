package com.app.service;

import com.app.pojo.User;

public interface IUserService {
	
	//to get admin by email and password
	public Object authenticateUser(User user);
}
