package com.heathbot.beans;
// Generated Jan 18, 2018 5:18:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblSection.
 * @see .TblSection
 * @author Hibernate Tools
 */
@Stateless
public class TblSectionHome {

	private static final Log log = LogFactory.getLog(TblSectionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblSection transientInstance) {
		log.debug("persisting TblSection instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblSection persistentInstance) {
		log.debug("removing TblSection instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblSection merge(TblSection detachedInstance) {
		log.debug("merging TblSection instance");
		try {
			TblSection result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblSection findById(Integer id) {
		log.debug("getting TblSection instance with id: " + id);
		try {
			TblSection instance = entityManager.find(TblSection.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
