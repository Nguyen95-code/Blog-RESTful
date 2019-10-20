package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.BlogCategoryName;

import java.util.List;

public interface BlogService extends GeneralService<Blog> {
    BlogCategoryName findById(long id);
    List<BlogCategoryName> findAllWithCategory();
}
