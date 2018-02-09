package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblUserType.
 * @see .TblUserType
 * @author Hibernate Tools
 */
@Stateless
public class TblUserTypeHome {

	private static final Log log = LogFactory.getLog(TblUserTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblUserType transientInstance) {
		log.debug("persisting TblUserType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblUserType persistentInstance) {
		log.debug("removing TblUserType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblUserType merge(TblUserType detachedInstance) {
		log.debug("merging TblUserType instance");
		try {
			TblUserType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblUserType findById(Integer id) {
		log.debug("getting TblUserType instance with id: " + id);
		try {
			TblUserType instance = entityManager.find(TblUserType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
