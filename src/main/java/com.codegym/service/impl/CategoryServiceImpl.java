package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.model.BlogCategoryName;
import com.codegym.model.Category;
import com.codegym.model.CategoryNoBlogName;
import com.codegym.repository.CategoryRepository;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<BlogCategoryName> findAllByCategory(long id) {
        List<Blog> blogs = categoryRepository.findAllByCategory(id);
        return getBlogCategoryNames(blogs);
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
    public List<CategoryNoBlogName> fincAllNoBlogName() {
        return getCategoryNoBlogName(findAll());
    }

    private List<CategoryNoBlogName> getCategoryNoBlogName(List<Category> categories) {
        List<CategoryNoBlogName> categoryNoBlogNames = new ArrayList<>();
        for (int i=0; i<categories.size(); i++){
            Category category = categories.get(i);
            categoryNoBlogNames.add(new CategoryNoBlogName(category.getId(), category.getName()));
        }
        return categoryNoBlogNames;
    }
}
