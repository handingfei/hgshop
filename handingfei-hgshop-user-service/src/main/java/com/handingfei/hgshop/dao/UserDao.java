package com.handingfei.hgshop.dao;

import com.handingfei.hgshop.domian.User;

public interface UserDao {

	User getByPwd(User user);

	User findByName(String userName);
	
	int add(User user);

}
