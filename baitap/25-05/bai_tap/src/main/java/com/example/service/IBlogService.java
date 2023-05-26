package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAll(int page);

    void save(Blog blog);

    Blog getBlogById(int id);

    void delete(Integer id);

    List<Blog> findAllByTitle(String title);
}
