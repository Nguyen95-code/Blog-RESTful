package com.codegym.service;

import com.codegym.model.BlogCategoryName;
import com.codegym.model.Category;
import com.codegym.model.CategoryNoBlogName;

import java.util.List;

public interface CategoryService extends GeneralService<Category>{
    List<BlogCategoryName> findAllByCategory(long id);
    List<CategoryNoBlogName> fincAllNoBlogName();
}
