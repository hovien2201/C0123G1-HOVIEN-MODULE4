package com.example.repository;

import com.example.model.Blog;

import com.example.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByTitle(String title);
    List<Blog> findAllByCategory_CategoryId(Integer categoryId);
}
