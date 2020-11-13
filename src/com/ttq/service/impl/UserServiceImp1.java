package com.ttq.service.impl;

import java.util.ArrayList;

import com.ttq.entity.User;
import com.ttq.service.UserService;
import com.ttq.util.ObjectUtil;

public class UserServiceImp1 implements UserService {
	private ArrayList<User> userList;

	private static final UserServiceImp1 userService = new UserServiceImp1();

	public static UserServiceImp1 getUserService() {
		return userService;
	}

	private UserServiceImp1() {
		userList = ObjectUtil.fileToObject("user.txt");
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		boolean flag = userList.add(user);
		ObjectUtil.objectToFile(userList, "user.txt");
		return flag;
	}

}
