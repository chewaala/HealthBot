package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblStudy.
 * @see .TblStudy
 * @author Hibernate Tools
 */
@Stateless
public class TblStudyHome {

	private static final Log log = LogFactory.getLog(TblStudyHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblStudy transientInstance) {
		log.debug("persisting TblStudy instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblStudy persistentInstance) {
		log.debug("removing TblStudy instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblStudy merge(TblStudy detachedInstance) {
		log.debug("merging TblStudy instance");
		try {
			TblStudy result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblStudy findById(Integer id) {
		log.debug("getting TblStudy instance with id: " + id);
		try {
			TblStudy instance = entityManager.find(TblStudy.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
