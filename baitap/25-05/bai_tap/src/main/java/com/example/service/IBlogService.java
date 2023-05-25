package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    void save(Blog blog);

    Blog getBlogById(int id);

    void delete(Integer id);

    List<Blog> findAllByTitleContaining(String title);
}
