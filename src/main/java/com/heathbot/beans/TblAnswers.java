package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TblAnswers generated by hbm2java
 */
@Entity
@Table(name = "tbl_answers", catalog = "healthbot")
public class TblAnswers implements java.io.Serializable {

	private Integer answerId;
	private TblUsers tblUsers;
	private TblModules tblModules;
	private String answer;
	private Set<TblUserModuleSurvey> tblUserModuleSurveys = new HashSet<TblUserModuleSurvey>(0);

	public TblAnswers() {
	}

	public TblAnswers(TblUsers tblUsers, TblModules tblModules, String answer,
			Set tblUserModuleSurveys) {
		this.tblUsers = tblUsers;
		this.tblModules = tblModules;
		this.answer = answer;
		this.tblUserModuleSurveys = tblUserModuleSurveys;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "answer_id", unique = true, nullable = false)
	public Integer getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public TblUsers getTblUsers() {
		return this.tblUsers;
	}

	public void setTblUsers(TblUsers tblUsers) {
		this.tblUsers = tblUsers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id")
	public TblModules getTblModules() {
		return this.tblModules;
	}

	public void setTblModules(TblModules tblModules) {
		this.tblModules = tblModules;
	}

	@Column(name = "answer", length = 65535)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblAnswers")
	public Set<TblUserModuleSurvey> getTblUserModuleSurveys() {
		return this.tblUserModuleSurveys;
	}

	public void setTblUserModuleSurveys(
			Set<TblUserModuleSurvey> tblUserModuleSurveys) {
		this.tblUserModuleSurveys = tblUserModuleSurveys;
	}

}