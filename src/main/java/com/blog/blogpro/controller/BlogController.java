package com.blog.blogpro.controller;

import com.blog.blogpro.dto.BlogDto;
import com.blog.blogpro.modal.Blog;
import com.blog.blogpro.repository.BlogRespository;
import com.blog.blogpro.service.BlogService;
import com.blog.blogpro.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blog")
    public List<Blog> index() {
        return blogService.getBlogList();
    }


    @GetMapping("/blog/{id}")
    public CommonResponse getBlogById(@PathVariable("id") Integer id) {
        return blogService.getBlog(id);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogService.search(searchTerm, searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody BlogDto blog){
        return blogService.addBlog(blog);

    }

    @PutMapping("/blog/{id}")
    public CommonResponse update(@PathVariable Integer id, @RequestBody BlogDto blog){

        return blogService.updateBlog(id, blog);
    }
    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable Integer id){

        blogService.deleteBlog(id);

        return true;
    }
}
