package com.ttq.service;

import com.ttq.entity.Admin;

public interface AdminService {
	//登陆
	Admin login(String username, String password);

	//注册
	boolean register(Admin admin);
}
