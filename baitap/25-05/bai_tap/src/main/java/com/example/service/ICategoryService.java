package com.example.service;

import com.example.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    void save(Category category);
    Page<Category> findAll(int page);
    List<Category> findAll();

    Category findById(Integer id);

    boolean delete(Integer id);
}
