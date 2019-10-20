package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.model.BlogCategoryName;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<BlogCategoryName> findAllWithCategory() {

        List<Blog> blogs =  findAll();
        List<BlogCategoryName> blogCategoryNames = getBlogCategoryNames(blogs);
        return blogCategoryNames;
    }

    private List<BlogCategoryName> getBlogCategoryNames(List<Blog> blogs) {
        List<BlogCategoryName> blogCategoryNames = new ArrayList<>();
        for (int i=0; i<blogs.size(); i++){
            Blog blog = blogs.get(i);
            blogCategoryNames.add(new BlogCategoryName(blog.getId(),blog.getTitle(),blog.getDescription(), blog.getContent(), blog.getDateCreate(), blog.getCategory().getName()));
        }
        return blogCategoryNames;
    }

    @Override
    public BlogCategoryName findById(long id) {
        Blog blog = blogRepository.findById(id);
        return new BlogCategoryName(blog.getId(),blog.getTitle(),blog.getDescription(), blog.getContent(), blog.getDateCreate(), blog.getCategory().getName());
    }


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
