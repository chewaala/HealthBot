package com.heathbot.study.business;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heathbot.beans.TblStudy;
import com.heathbot.beans.TblUsers;
import com.heathbot.study.dao.StudyDao;


public class StudyBusiness {

	public int userId;
	
	StudyDao studyDao;
	
	public StudyDao getStudyDao() {
		return studyDao;
	}

	public void setStudyDao(StudyDao studyDao) {
		this.studyDao = studyDao;
	}	

	// # Study Section
	//fetch single study record
		public TblStudy getSingleStudy(int studyId){
		
			TblStudy study = studyDao.getSingleStudy(studyId);
			//System.out.println(study);
			return study;
		}
		
	//Fetch all study details
	public List<TblStudy> getAllStudies(){
		List<TblStudy> studyList = studyDao.getAllStudies();
		return studyList;
	}
	
	
	//save study
	public int saveStudy(TblStudy tblStudy){
		int studyId = studyDao.saveStudy(tblStudy);
		return studyId;
	}
	
	
}
