package com.heathbot.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.heathbot.beans.TblUsers;

public class UserDao {
	
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//fetch single User record
		public TblUsers getSingleUser(int userId){	
			TblUsers user = hibernateTemplate.get(TblUsers.class, userId);
			return user;
		}
		
	//Fetch all users records
		public List<TblUsers> getAllUsers(){
			List<TblUsers> userList = hibernateTemplate.loadAll(TblUsers.class);
			for (TblUsers tblUsers : userList) {
				System.out.println("User id : " + tblUsers.getUserId());
			}
			return userList;
		}
		
	// Get all user ids
		public List<TblUsers> getAllUserIds(){
			List<TblUsers> allUserIds = hibernateTemplate.loadAll(TblUsers.class);
			for (TblUsers tblUsers : allUserIds) {
				System.out.println("User id : " + tblUsers.getUserId());
			}
			
			return allUserIds;
		}
		
		
		//save Users
				public int saveUsers(TblUsers tblUsers){
					System.out.println("In User Dao" + tblUsers.getUserName() + " Gender " + tblUsers.getGender() + " Goals " + tblUsers.getGoals());
					
					int saveStudy = (Integer) hibernateTemplate.save(tblUsers);
					
					
					return saveStudy;
				}

}
