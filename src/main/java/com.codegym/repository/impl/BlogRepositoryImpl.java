package com.codegym.repository.impl;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("SELECT b from Blog b", Blog.class);
        return query.getResultList();
    }


    @Override
    public Blog findById(long id) {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b where b.id = :id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
}
