package com.healthbot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.heathbot.beans.TblUsers;
import com.heathbot.user.business.UserBusiness;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("userBusiness")
	public UserBusiness userBusiness;

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	//---------------------------------------
	@RequestMapping(value = "/users/{userId}")
	public ModelAndView getAllUsers(@PathVariable int userId){
		TblUsers user = userBusiness.getSingleUser(userId);
		return new ModelAndView("userpage", "user", user);
	}
	
	
	 @RequestMapping( method=RequestMethod.GET, value="/subView" )
	    public ModelAndView getSubView( Model model ) {
	        model.addAttribute( "user", "Joe Dirt" );
	        model.addAttribute( "time", new Date() );
	        return new ModelAndView( "subView" );
	    }
	 
	 @RequestMapping( method=RequestMethod.GET, value="/userDetailssubview/{userid}" )
	    public ModelAndView getGetSingleUser( Model model, @PathVariable int userid ) {
		 try {
			 if (userid == 0) {
				 System.out.println("User id is not available");
				}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		 TblUsers user = userBusiness.getSingleUser(userid);
		 int userId = user.getUserId();
		 String userName = user.getUserName();
		 String userGender = user.getGender();
		 String userGoals = user.getGoals();
		 //String userType = user.getTblUserType().getUserTypeName();
	     model.addAttribute("userId", userId);
	     model.addAttribute("userName", userName);
	     model.addAttribute("userGender", userGender);
	     model.addAttribute("userGoals", userGoals);
	        return new ModelAndView( "subview-singleuser" );
	    }

	 @RequestMapping( method=RequestMethod.GET, value="/userDetailssubview" )
	    public ModelAndView getGetSingleUsers( Model model ) {
		 TblUsers user = userBusiness.getSingleUser(2);
		 int userId = user.getUserId();
		 String userName = user.getUserName();
		 String userGender = user.getGender();
		 String userGoals = user.getGoals();
		 int userTypeId = user.getTblUserType().getUserTypeId();
	     model.addAttribute("userId", userId);
	     model.addAttribute("userName", userName);
	     model.addAttribute("userGender", userGender);
	     model.addAttribute("userGoals", userGoals);
	     model.addAttribute("userTypeId", userTypeId);
	     return new ModelAndView( "subview-singleuser" );
	    }
	 
	 @RequestMapping( method=RequestMethod.GET, value="/userDetailssubview/{userID}" )
	    public ModelAndView getGetSingleUserDetails( Model model, @PathVariable int userID ) {
		 TblUsers user = userBusiness.getSingleUser(userID);
		 int userId = user.getUserId();
		 String userName = user.getUserName();
		 String userGender = user.getGender();
		 String userGoals = user.getGoals();
		 int userTypeId = user.getTblUserType().getUserTypeId();
	     model.addAttribute("userId", userId);
	     model.addAttribute("userName", userName);
	     model.addAttribute("userGender", userGender);
	     model.addAttribute("userGoals", userGoals);
	     model.addAttribute("userTypeId", userTypeId);
	     return new ModelAndView( "subview-singleuser" );
	    }

}
