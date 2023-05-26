package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.IBlogRepository;
import com.example.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Page<Category> findAll(int page) {
        return iCategoryRepository.findAll(PageRequest.of(page,6));
    }
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public boolean delete(Integer id) {
        List<Blog> blogList=iBlogRepository.findAll();
        for (int i = 0; i < blogList.size(); i++) {
            if (blogList.get(i).getCategory().getCategoryId()==id){
                return false;
            }
        }
        iCategoryRepository.deleteById(id);
        return true;
    }
}
