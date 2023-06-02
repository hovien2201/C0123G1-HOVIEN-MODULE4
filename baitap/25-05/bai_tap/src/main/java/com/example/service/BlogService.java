package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> getAll(int page) {
        return iBlogRepository.findAll(PageRequest.of(page,6,Sort.by("createAt").descending()));
    }

    @Override
    public List<Blog> getAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog getBlogById(int id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAllByTitle(String title) {
        return iBlogRepository.findAllByTitle(title);
    }

    @Override
    public List<Blog> findAllByCategory(Category category) {
        return iBlogRepository.findAllByCategory(category);
    }
}
