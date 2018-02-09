package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblUsers.
 * @see .TblUsers
 * @author Hibernate Tools
 */
@Stateless
public class TblUsersHome {

	private static final Log log = LogFactory.getLog(TblUsersHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblUsers transientInstance) {
		log.debug("persisting TblUsers instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblUsers persistentInstance) {
		log.debug("removing TblUsers instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblUsers merge(TblUsers detachedInstance) {
		log.debug("merging TblUsers instance");
		try {
			TblUsers result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblUsers findById(Integer id) {
		log.debug("getting TblUsers instance with id: " + id);
		try {
			TblUsers instance = entityManager.find(TblUsers.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
