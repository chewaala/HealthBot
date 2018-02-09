package com.heathbot.study.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heathbot.beans.TblStudy;
import com.heathbot.study.business.StudyBusiness;

public class Client {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("healthbot-spring.cfg.xml");
		StudyBusiness studyBusiness = (StudyBusiness) context.getBean("studyBusiness");
		List<TblStudy> studyList = studyBusiness.getAllStudies();
		studyBusiness.getSingleStudy(2);
	}

}
