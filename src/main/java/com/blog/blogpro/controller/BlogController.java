package com.blog.blogpro.controller;

import com.blog.blogpro.modal.Blog;
import com.blog.blogpro.repository.BlogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogRespository blogRespository;
    @GetMapping("/blog")
    public List<Blog> index() {
        return blogRespository.findAll();
    }
}
