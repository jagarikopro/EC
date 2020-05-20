package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.exception.EntityDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dbflute.exbhv.UserBhv;
import com.example.demo.dbflute.exentity.User;
import com.example.demo.dto.UserForm;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserBhv userBhv;

	@Autowired
	private AuthService authService;
	
	@Override
	public boolean save(UserForm userForm) {

		User user = userBhv.selectEntityWithDeletedCheck(cb -> {
			cb.query().setEmail_Equal(userForm.getEmail());
		});

		if(user == null){

		String hashPassword = authService.encode(userForm.getPassword(), AuthService.ENCKEY,
			AuthService.IVEC, AuthService.CHARSET);

//		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setPassword(hashPassword);
		user.setCreated(LocalDateTime.now());
		userBhv.insert(user);

		return true;
		};

		return false;

	}

	@Override
	public List<User> getAll() {

		ListResultBean<User> userList = userBhv.selectList(cb -> {
			cb.query().addOrderBy_UserId_Desc();
		});
		return userList;
	}

	@Override
	public void update(User user) {
		try {
			// Taskを更新 idが無ければ例外発生
			userBhv.update(user);
		} catch (EntityDuplicatedException e) {
			throw new NotFoundException("更新するユーザが存在しません");
		}
		
	}
	

}
