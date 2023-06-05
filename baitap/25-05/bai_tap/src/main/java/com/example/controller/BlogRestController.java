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
@RequestMapping("api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAllBlog(){
        return new ResponseEntity<>(iBlogService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showDetailBlogByPathVariable(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(iBlogService.getBlogById(id),HttpStatus.OK);
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<List<Blog>> getAllBlogInCategory(@PathVariable("id") Integer categoryId){
        return new ResponseEntity<>(iBlogService.findAllByCategory(categoryId),HttpStatus.OK);
    }

}
