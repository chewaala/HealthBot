package com.heathbot.usertype.business;

import com.heathbot.beans.TblUserType;
import com.heathbot.usertype.dao.UserTypeDAO;


public class UserTypeBusiness {
	
	UserTypeDAO userTypeDAO;

	public UserTypeDAO getUserTypeDAO() {
		return userTypeDAO;
	}

	public void setUserTypeDAO(UserTypeDAO userTypeDAO) {
		this.userTypeDAO = userTypeDAO;
	}
	
	public TblUserType getUserType(int userTypeId){
		TblUserType userType = userTypeDAO.getUserType(userTypeId);
		return userType;
	}

	//save user type
	public int saveUserType(TblUserType tblUserType){
		int userTypeId = userTypeDAO.saveUserType(tblUserType);
		return userTypeId;
	}
}
