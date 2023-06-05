package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAll(int page);
    List<Blog> getAll();

    void save(Blog blog);

    Blog getBlogById(int id);

    void delete(Integer id);

    List<Blog> findAllByTitle(String title);
    List<Blog> findAllByCategory(Integer categoryId);
}
