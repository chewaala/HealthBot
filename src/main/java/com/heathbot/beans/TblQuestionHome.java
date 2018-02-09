package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblQuestion.
 * @see .TblQuestion
 * @author Hibernate Tools
 */
@Stateless
public class TblQuestionHome {

	private static final Log log = LogFactory.getLog(TblQuestionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblQuestion transientInstance) {
		log.debug("persisting TblQuestion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblQuestion persistentInstance) {
		log.debug("removing TblQuestion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblQuestion merge(TblQuestion detachedInstance) {
		log.debug("merging TblQuestion instance");
		try {
			TblQuestion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblQuestion findById(Integer id) {
		log.debug("getting TblQuestion instance with id: " + id);
		try {
			TblQuestion instance = entityManager.find(TblQuestion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
