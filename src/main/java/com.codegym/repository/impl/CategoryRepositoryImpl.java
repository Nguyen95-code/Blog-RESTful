package com.codegym.repository.impl;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Category> findAll() {
        TypedQuery<Category> query = em.createQuery("select c from Category c", Category.class);
        return query.getResultList();
    }

    @Override
    public List<Blog> findAllByCategory(long id) {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b where b.category.id = :id", Blog.class);
        query.setParameter("id",id);
        try {
            return query.getResultList();
        } catch (NoResultException e){
            return null;
        }
    }
}
