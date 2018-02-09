package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblModules.
 * @see .TblModules
 * @author Hibernate Tools
 */
@Stateless
public class TblModulesHome {

	private static final Log log = LogFactory.getLog(TblModulesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblModules transientInstance) {
		log.debug("persisting TblModules instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblModules persistentInstance) {
		log.debug("removing TblModules instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblModules merge(TblModules detachedInstance) {
		log.debug("merging TblModules instance");
		try {
			TblModules result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblModules findById(Integer id) {
		log.debug("getting TblModules instance with id: " + id);
		try {
			TblModules instance = entityManager.find(TblModules.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
