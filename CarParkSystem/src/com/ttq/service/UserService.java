package com.ttq.service;

import com.ttq.entity.User;

public interface UserService {
	//登陆
	User login(String username, String password);

	//注册
	boolean register(User user);
}
