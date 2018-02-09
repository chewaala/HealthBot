package com.heathbot.usertype.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.heathbot.beans.TblUserType;

public class UserTypeDAO {
	
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
		//save user Type
			public int saveUserType(TblUserType tblUserType){
				System.out.println("In User Type Dao " + tblUserType.getUserTypeName());
				
				int tblUserTypeId = (Integer) hibernateTemplate.save(tblUserType);
				
				
				return tblUserTypeId;
			}
			
			//get single user type
			public TblUserType getUserType(int userTypeId){	
				TblUserType tblUserType = hibernateTemplate.get(TblUserType.class, userTypeId);
				return tblUserType;
			}
		

}
