package com.blog.blogpro.service.impl;

import com.blog.blogpro.dto.BlogDto;
import com.blog.blogpro.exception.RecordNotFoundException;
import com.blog.blogpro.modal.Blog;
import com.blog.blogpro.repository.BlogRespository;
import com.blog.blogpro.service.BlogService;
import com.blog.blogpro.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRespository blogRespository;

    @Override
    public List<Blog> getBlogList() {
        return blogRespository.findAll();
    }

    @Override
    public CommonResponse getBlog(Integer id) {
        CommonResponse commonResponse = new CommonResponse();
        Optional<Blog> blog =  blogRespository.findById(id);
        if (!blog.isPresent()) {
            commonResponse.setStatus(HttpStatus.NO_CONTENT);
            commonResponse.setMessage("Blog Not Found!");
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(blog.get());
            commonResponse.setMessage("Blog Successfully Found!");
        }
        commonResponse.setTimestamp(LocalDateTime.now());
        return  commonResponse;
    }

    @Override
    public List<Blog> search(String searchTerm, String searchTerm1) {
        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);

    }

    @Override
    public Blog addBlog(BlogDto blog) {
        return blogRespository.save(new Blog(blog.getTitle(), blog.getContent()));
    }

    @Override
    public CommonResponse updateBlog(Integer id, BlogDto blog) {
        CommonResponse commonResponse = new CommonResponse();
        Blog existingBlog = blogRespository.findById(id).orElseThrow(()->new RecordNotFoundException("Blog not found!"));
        existingBlog.setContent(blog.getContent());
        existingBlog.setTitle(blog.getTitle());
        commonResponse.setData(blogRespository.save(existingBlog));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setTimestamp(LocalDateTime.now());
        commonResponse.setMessage("Blog Successfully Updated!");
        return commonResponse;


    }

    @Override
    public boolean deleteBlog(Integer blogId) {
        blogRespository.deleteById(blogId);
        return true;
    }


}
