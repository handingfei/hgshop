package com.handingfei.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.handingfei.hgshop.domian.User;
import com.handingfei.hgshop.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Reference
	UserService userService;
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@GetMapping("register")
	public String register() {
		return "user/register";
	} 
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@PostMapping("register")
	public String register(HttpServletRequest request,User user) {
		int register = userService.register(user);
		if(register>0)
			return "redirect:user/login";
		
		return "user/register";
	}
	
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@GetMapping("login")
	public String login() {
		return "user/login";
	} 
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@PostMapping("login")
	public String login(HttpServletRequest request,User user) {
		User loginUser = userService.login(user);
		if(loginUser == null)
			return "user/login";
		
		request.getSession().setAttribute("login_user", loginUser);
		return "redirect:user/home";
	}
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@PostMapping("logout")
	public String login(HttpServletRequest request) {
		request.getSession().removeAttribute("login_user");
		return "redirect:user/home";
	}
	
	
	
	@RequestMapping("exist")
	@ResponseBody
	public boolean register(String username) {
		// 返回的含义标识是否可以注册
		return !userService.exist(username);
	} 

}
