package com.codegym.controller;

import com.codegym.model.BlogCategoryName;
import com.codegym.model.CategoryNoBlogName;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories/", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryNoBlogName>> listAllCategories() {
        List<CategoryNoBlogName> categories = categoryService.fincAllNoBlogName();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<CategoryNoBlogName>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<CategoryNoBlogName>>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<BlogCategoryName>> viewCategory(@PathVariable long id) {
        List<BlogCategoryName> blogCategoryNames = categoryService.findAllByCategory(id);
        if (blogCategoryNames.isEmpty()) {
            return new ResponseEntity<List<BlogCategoryName>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BlogCategoryName>>(blogCategoryNames, HttpStatus.OK);
    }
}
