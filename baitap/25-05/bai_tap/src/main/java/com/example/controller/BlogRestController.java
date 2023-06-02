package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/adim/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> getAllBlog(){
        return new ResponseEntity<>(iBlogService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory(){
        return new ResponseEntity<>(iCategoryService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> getAllBlogInCategory(@PathVariable("id") Integer id){
        Category category=iCategoryService.findById(id);
        return new ResponseEntity<>(iBlogService.findAllByCategory(category),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> detailByPathVariable(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(iBlogService.getBlogById(id),HttpStatus.OK);
    }

}
