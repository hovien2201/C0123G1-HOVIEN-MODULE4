package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> getAll(int page) {
        return iBlogRepository.findAll(PageRequest.of(page, 6, Sort.by("createAt").descending()));
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
    public Page<Blog> findAllByTitle(String title, Pageable pageable) {
        return iBlogRepository.findCategory(title, pageable);
    }

    @Override
    public List<Blog> findAllByCategory(Integer categoryId) {

        return iBlogRepository.findAllByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Blog> searchBlogByTitle(String title) {
        return iBlogRepository.searchBlog(title);
    }

    @Override
    public List<Blog> loadMore(Integer number) {
        List<Blog> blogList = iBlogRepository.findAll();
        List<Blog> blogs = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < blogList.size() && i < number * 5; i++) {
            if (i >= (number - 1) * 5) {
                blogs.add(j, blogList.get(i));
                j++;
            }
        }
        return blogs;

    }
}
