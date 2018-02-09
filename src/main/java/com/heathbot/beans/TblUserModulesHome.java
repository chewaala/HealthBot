package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblUserModules.
 * @see .TblUserModules
 * @author Hibernate Tools
 */
@Stateless
public class TblUserModulesHome {

	private static final Log log = LogFactory.getLog(TblUserModulesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblUserModules transientInstance) {
		log.debug("persisting TblUserModules instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblUserModules persistentInstance) {
		log.debug("removing TblUserModules instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblUserModules merge(TblUserModules detachedInstance) {
		log.debug("merging TblUserModules instance");
		try {
			TblUserModules result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblUserModules findById(Integer id) {
		log.debug("getting TblUserModules instance with id: " + id);
		try {
			TblUserModules instance = entityManager.find(TblUserModules.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
