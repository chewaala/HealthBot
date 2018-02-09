package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblAnswers.
 * @see .TblAnswers
 * @author Hibernate Tools
 */
@Stateless
public class TblAnswersHome {

	private static final Log log = LogFactory.getLog(TblAnswersHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblAnswers transientInstance) {
		log.debug("persisting TblAnswers instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblAnswers persistentInstance) {
		log.debug("removing TblAnswers instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblAnswers merge(TblAnswers detachedInstance) {
		log.debug("merging TblAnswers instance");
		try {
			TblAnswers result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblAnswers findById(Integer id) {
		log.debug("getting TblAnswers instance with id: " + id);
		try {
			TblAnswers instance = entityManager.find(TblAnswers.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
