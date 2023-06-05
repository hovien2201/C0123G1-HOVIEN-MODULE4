package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAll(int page);
    List<Blog> getAll();

    void save(Blog blog);

    Blog getBlogById(int id);

    void delete(Integer id);

    Page<Blog> findAllByTitle(String title,Pageable pageable);
    List<Blog> findAllByCategory(Integer categoryId);

    List<Blog> searchBlogByTitle(String title);

    List<Blog> loadMore(Integer number);
}
