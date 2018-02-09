package com.healthbot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


@RequestMapping("/")
public class StudyController2 implements Controller {

	@RequestMapping("/viewemp")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	Map m = new HashMap();
	m.put("message", "AAmer");
		return new ModelAndView("hello", m);
	}

}
