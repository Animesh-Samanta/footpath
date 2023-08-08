package com.footpath.online.dao;

import org.springframework.stereotype.Repository;

import com.footpath.online.entity.CustomerEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(CustomerEntity customer) {
        entityManager.persist(customer);
    }

    public CustomerEntity findById(Long id) {
        return entityManager.find(CustomerEntity.class, id);
    }

    public List<CustomerEntity> findAll() {
        return entityManager.createQuery("SELECT c FROM CustomerEntity c", CustomerEntity.class)
                .getResultList();
    }

    public void update(CustomerEntity customer) {
        entityManager.merge(customer);
    }

    public void delete(CustomerEntity customer) {
        entityManager.remove(customer);
    }
    public CustomerEntity findByEmail(String email) {
    	try {
        return entityManager.createQuery("SELECT c FROM CustomerEntity c WHERE c.email = :email", CustomerEntity.class)
                .setParameter("email", email)
                .getSingleResult();
    	}
    	catch(NoResultException ex) {
    		return null;
    	}
    }
}
