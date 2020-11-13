package com.ttq.service.impl;

import java.util.ArrayList;

import com.ttq.entity.Admin;
import com.ttq.service.AdminService;
import com.ttq.util.ObjectUtil;

public class AdminServiceImpl implements AdminService {
	private ArrayList<Admin> adminlist;//管理员列表，读取文件
	//单例饿汉模式
	private static final AdminServiceImpl adminService = new AdminServiceImpl();
	public static AdminServiceImpl getAdminService() {
		return adminService;
	}
	private AdminServiceImpl() {
		adminlist = ObjectUtil.fileToObject("admin.txt");//加载文件内容成管理员集合
	}
	
	@Override
	public Admin login(String username, String password) {
		for (Admin admin:adminlist) {
			if (admin.getUsername().equals(username)&&admin.getPassword().equals(password)) {
				return admin;
			}
		}
		return null;
	}

	@Override
	public boolean register(Admin admin) {
		boolean flag = adminlist.add(admin);
		ObjectUtil.objectToFile(adminlist, "admin.txt");
		return flag;
	}

}
