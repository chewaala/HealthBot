package com.heathbot.user.business;

import java.util.List;

import com.heathbot.beans.TblUsers;
import com.heathbot.user.dao.UserDao;

public class UserBusiness {

	public UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// # User Section
	// fetch single study record
	public TblUsers getSingleUser(int userId) {
		TblUsers user = userDao.getSingleUser(userId);
		//System.out.println(user.getUserName() + " | " + user.getTblUserType().getUserTypeId());
		return user;
	}
	
	//Fetch all study details
		public List<TblUsers> getAllUser(){
			List<TblUsers> userList = userDao.getAllUsers();
			return userList;
		}
		
		//save study
		public int saveUsers(TblUsers tblUsers){
			int studyId = userDao.saveUsers(tblUsers);
			return studyId;
		}

}
