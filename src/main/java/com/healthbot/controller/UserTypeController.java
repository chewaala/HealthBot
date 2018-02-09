package com.healthbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.heathbot.beans.TblUserType;
import com.heathbot.beans.TblUsers;
import com.heathbot.usertype.business.UserTypeBusiness;

@Controller
public class UserTypeController {

	//Business object and its setter methods 
	@Autowired
	@Qualifier("userTypeBusiness")
	UserTypeBusiness userTypeBusiness;
	
	public UserTypeBusiness getUserTypeBusiness() {
		return userTypeBusiness;
	}

	public void setUserTypeBusiness(UserTypeBusiness userTypeBusiness) {
		this.userTypeBusiness = userTypeBusiness;
	}


	/*@RequestMapping("/usertype/{userTypeId}")
	public ModelAndView getUserType(@PathVariable int userTypeId){
		System.out.println("In controller with user type id " + userTypeId );
		TblUserType usertype = userTypeBusiness.getUserType(userTypeId);
		return new ModelAndView("usertypepage", "usertype", usertype);
	}*/
	
	
	@RequestMapping(value = "/usertype/{userTypeId}")
	public ModelAndView getAllUsers(@PathVariable int userTypeId){
		int id = userTypeId;
		System.out.println("User type controller and the id is :" + id);
		return new ModelAndView("userpage");
	}

}
