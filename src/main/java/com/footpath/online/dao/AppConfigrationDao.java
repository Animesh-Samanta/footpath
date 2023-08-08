package com.footpath.online.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footpath.online.constants.Domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class AppConfigrationDao {
	@PersistenceContext
	private EntityManager entityManager;
	 
	    public List<Domain> getAllEmailDomains() {
	        return entityManager.createQuery("FROM Domain", Domain.class).getResultList();
	    }

	    
	    public List<Domain> getBlockedEmailDomains() {
	        return entityManager.createQuery("FROM Domain WHERE isBlocked = false", Domain.class).getResultList();
	    }

	    
	    public List<Domain> getUnblockedEmailDomains() {
	        return entityManager.createQuery("FROM Domain WHERE isBlocked = true", Domain.class).getResultList();
	    }
}
