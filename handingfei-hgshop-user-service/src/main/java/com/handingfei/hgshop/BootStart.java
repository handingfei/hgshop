package com.handingfei.hgshop;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BootStart {

	public static void main(String[] args) throws IOException {
		
		System.out.println("准备..............");
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml","classpath:applicationContext-dubbo-provider.xml");
		System.out.println("启动中..............");
		context.start();
		
		System.in.read();
		System.out.println("成功..............");
	}
}
