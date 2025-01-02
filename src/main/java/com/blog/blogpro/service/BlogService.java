package com.blog.blogpro.service;

import com.blog.blogpro.dto.BlogDto;
import com.blog.blogpro.modal.Blog;
import com.blog.blogpro.util.CommonResponse;

import java.util.List;

public interface BlogService {
    List<Blog> getBlogList();

    CommonResponse getBlog(Integer id);

    List<Blog> search(String searchTerm, String searchTerm1);

    Blog addBlog(BlogDto blog);

    CommonResponse updateBlog(Integer id, BlogDto blogDto);

    boolean deleteBlog(Integer blogId);
}
