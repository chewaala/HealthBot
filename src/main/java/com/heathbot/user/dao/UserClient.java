package com.heathbot.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heathbot.user.business.UserBusiness;

public class UserClient {

public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("healthbot-spring.cfg.xml");
		UserBusiness userBusiness = (UserBusiness) context.getBean("userBusiness");
		userBusiness.getSingleUser(2);
	}
	
}
