package com.heathbot.study.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;






import com.heathbot.beans.TblStudy;
import com.heathbot.beans.TblUsers;

public class StudyDao {
	
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	// # Study Section
	//fetch single study record
	public TblStudy getSingleStudy(int studyId){
	
		TblStudy study = hibernateTemplate.get(TblStudy.class, studyId);
		return study;
	}
	
	//Fetch all study records
	public List<TblStudy> getAllStudies(){
		List<TblStudy> studyList = hibernateTemplate.loadAll(TblStudy.class);
		return studyList;
	}
	
	
	//save study
		public int saveStudy(TblStudy tblStudy){
			System.out.println("In Dao" + tblStudy.getStudyDesc() + " D1 " + tblStudy.getStartDate() + " D2 " + tblStudy.getEndDate());
			
			int saveStudy = (Integer) hibernateTemplate.save(tblStudy);
			
			
			return saveStudy;
		}
	
	
	
	
	
	
}
