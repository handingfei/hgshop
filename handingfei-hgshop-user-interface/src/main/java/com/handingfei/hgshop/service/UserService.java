package com.handingfei.hgshop.service;

import com.handingfei.hgshop.domian.User;

public interface UserService {
	
	User login(User user);
	int register(User user);
	
	boolean exist(String userName);
	
	
}
