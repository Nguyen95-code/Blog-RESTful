package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;

import java.util.List;

public interface CategoryRepository extends GeneralRepository<Category> {
    List<Blog> findAllByCategory(long id);
}
