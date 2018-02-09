package com.healthbot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.heathbot.beans.TblStudy;
import com.heathbot.beans.TblUserType;
import com.heathbot.beans.TblUsers;
import com.heathbot.study.business.StudyBusiness;
import com.heathbot.user.business.UserBusiness;
import com.heathbot.usertype.business.UserTypeBusiness;


@Controller
public class StudyController {

	//public int userId;
	
	public StudyBusiness studyBusiness;
	
	public StudyBusiness getStudyBusiness() {
		return studyBusiness;
	}

	public void setStudyBusiness(StudyBusiness studyBusiness) {
		this.studyBusiness = studyBusiness;
	}
	
	@Autowired
	@Qualifier("userBusiness")
	public UserBusiness userBusiness;
	
	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	@Autowired
	@Qualifier("userTypeBusiness")
	UserTypeBusiness userTypeBusiness;
	
	public UserTypeBusiness getUserTypeBusiness() {
		return userTypeBusiness;
	}

	public void setUserTypeBusiness(UserTypeBusiness userTypeBusiness) {
		this.userTypeBusiness = userTypeBusiness;
	}

	//---------------------------------------------------------
	@RequestMapping(value = "/studies")
	public ModelAndView getAllStudies(){
		List<TblStudy> list = studyBusiness.getAllStudies(); 
		return new ModelAndView("studypage", "list", list);
	}
	
	
	@RequestMapping("/studyform")
	public ModelAndView showForm() {

		return new ModelAndView("studyform", "command", new TblStudy());

	}
	
	@RequestMapping(value="/saveStudy",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("tblStudy") TblStudy tblStudy){  
    	System.out.println("Des"+tblStudy.getStudyDesc());
    	studyBusiness.saveStudy(tblStudy);
        return new ModelAndView("redirect:/studies");//will redirect to viewemp request mapping  
    }  
	
	@RequestMapping("/showstudyform")
	public ModelAndView showststudyForm() {

		return new ModelAndView("studyformpage", "command", new TblStudy());

	}
	
	@RequestMapping(value="/savestudyform")  
    public ModelAndView savestudyform(Model model, HttpServletRequest request, HttpServletResponse response){  
    	  
		String studyTitle = request.getParameter("studyDesc");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String goals = request.getParameter("goals");
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		String usertype = request.getParameter("usertype");
		
		
		System.out.println(" |Title :" + studyTitle);
		System.out.println(" |Start date :" + startDate);
		System.out.println(" |End date :" + endDate);
		System.out.println(" |username :" + username);
		System.out.println(" |Goals :" + goals);
		System.out.println(" |Gender :" + gender);
		System.out.println(" |User Type Name :" + usertype);
		//System.out.println(" |User Id :" + userId);
		
		//convert the string dates to Date format
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date covertedStartDate = null;
		Date covertedEndtDate = null;
		try {
			covertedStartDate = dateFormat.parse(startDate);
			covertedEndtDate = dateFormat.parse(endDate);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
        //Study
		TblStudy tblStudy = new TblStudy();
        tblStudy.setStudyDesc(studyTitle);
        tblStudy.setStartDate(covertedStartDate);        
        tblStudy.setEndDate(covertedEndtDate);
        
        
        
        //add the User information
        TblUsers tblUsers = new TblUsers();
        List<TblUsers> user = userBusiness.getAllUser();
        
        //take a list for saving just user ids
        List<Integer> user2 = new ArrayList<Integer>();
        
        for (TblUsers tblUsers2 : user) {
        	user2.add(tblUsers2.getUserId());
		}
        //save the last user id in a integer variable
        int lastUserId = user2.get(user2.size() - 1);
        System.out.println("last user id " + lastUserId);
        //increment the user id by one
        int increamentUserIdByOne = lastUserId + 1;
        
        //set the user id to the user id setter method
        tblUsers.setUserId(increamentUserIdByOne);
        tblUsers.setUserName(username);
        tblUsers.setGoals(goals);
        tblUsers.setGender(gender);
        
        
        
        //save the user table to study table
        tblStudy.setTblUsers(tblUsers);
        System.out.println("saved id is " + tblUsers.getUserId());
		
        //also save this user id as a foreign key of study
        
        
        //User Type
        TblUserType tblUserType = new TblUserType();
        if (usertype.equalsIgnoreCase("Researcher")) {
        	tblUserType.setUserTypeId(1);
		}else if (usertype.equalsIgnoreCase("Practitioner")) {
			tblUserType.setUserTypeId(2);
		}else {
			tblUserType.setUserTypeId(3);;
		}
        
        //save the user type table to user table
        tblUsers.setTblUserType(tblUserType);
        
        
        
		//first save user type then save users then save study
        /*int userTypeId = userTypeBusiness.saveUserType(tblUserType);
        System.out.println("Your user Type Id is " + userTypeId);*/
       
        int userIds = userBusiness.saveUsers(tblUsers);
		System.out.println("User data has been saved. Your User id is " + userIds);
        
        int saveStudy = studyBusiness.saveStudy(tblStudy);
        System.out.println("Study data has been saved. Your study id is :" + saveStudy);
        
		return new ModelAndView("redirect:/studies");
    }  
	
	
	
}
