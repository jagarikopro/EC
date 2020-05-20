package com.example.demo.service;

import java.util.List;

import com.example.demo.dbflute.exentity.User;
import com.example.demo.dto.UserForm;

public interface UserService {
	
	boolean save(UserForm userForm);
	
	void update(User user);
	
	List<User>  getAll();

}
