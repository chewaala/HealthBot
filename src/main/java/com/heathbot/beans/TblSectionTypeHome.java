package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblSectionType.
 * @see .TblSectionType
 * @author Hibernate Tools
 */
@Stateless
public class TblSectionTypeHome {

	private static final Log log = LogFactory.getLog(TblSectionTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblSectionType transientInstance) {
		log.debug("persisting TblSectionType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblSectionType persistentInstance) {
		log.debug("removing TblSectionType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblSectionType merge(TblSectionType detachedInstance) {
		log.debug("merging TblSectionType instance");
		try {
			TblSectionType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblSectionType findById(Integer id) {
		log.debug("getting TblSectionType instance with id: " + id);
		try {
			TblSectionType instance = entityManager.find(TblSectionType.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
