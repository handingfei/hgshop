package com.handingfei.hgshop.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.handingfei.hgshop.dao.UserDao;
import com.handingfei.hgshop.domian.User;
import com.handingfei.hgshop.service.UserService;

@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		String pwdMd5 = DigestUtils.md5Hex(user.getPassword() + user.getUsername());
		user.setPassword(pwdMd5);
		//根据用户名密码查找
		return userDao.getByPwd(user);
		
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		//数据库当中要保存密码的密文  + 加盐（用户名做盐）
		String pwdMd5 = DigestUtils.md5Hex(user.getPassword() + user.getUsername());
		user.setPassword(pwdMd5);
		return userDao.add(user);
		
	}

	@Override
	public boolean exist(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByName(userName)!=null;
	}
		

	
}
