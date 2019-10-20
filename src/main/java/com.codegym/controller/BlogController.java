package com.codegym.controller;

import com.codegym.model.BlogCategoryName;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/blogs/", method = RequestMethod.GET)
    public ResponseEntity<List<BlogCategoryName>> listAllBlogs() {
        List<BlogCategoryName> blogList = blogService.findAllWithCategory();
        if (blogList.isEmpty()) {
            return new ResponseEntity<List<BlogCategoryName>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BlogCategoryName>>(blogList, HttpStatus.OK);
    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public ResponseEntity<BlogCategoryName> viewBlog(@PathVariable long id) {
        BlogCategoryName blogCategoryName = blogService.findById(id);
        if (blogCategoryName == null) {
            return new ResponseEntity<BlogCategoryName>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<BlogCategoryName>(blogCategoryName, HttpStatus.OK);
    }

}
