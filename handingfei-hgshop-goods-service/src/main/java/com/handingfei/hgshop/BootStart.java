package com.handingfei.hgshop;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BootStart {

public static void main(String[] args) throws IOException {
		
		System.out.println("准备启动商品服务的提供者....................");
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:applicationContext-dubbo-provider.xml","classpath:applicationContext-dao.xml");
		System.out.println("正在启动商品服务提供者...........");
		context.start();
		
		System.out.println(" 启动成功！！！");
		
		System.in.read();
	}
}
