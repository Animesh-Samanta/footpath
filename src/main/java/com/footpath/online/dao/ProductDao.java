package com.footpath.online.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.footpath.online.entity.ProductEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductEntity findById(Long productId) {
        return entityManager.find(ProductEntity.class, productId);
    }

    public List<ProductEntity> findAll() {
        return entityManager.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class)
                            .getResultList();
    }

    public void save(ProductEntity product) {
        entityManager.persist(product);
    }

    public void update(ProductEntity product) {
        entityManager.merge(product);
    }

    public void delete(ProductEntity product) {
        entityManager.remove(product);
    }
}
