package com.blog.blogpro.repository;

import com.blog.blogpro.modal.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRespository extends JpaRepository<Blog, Integer> {
}
