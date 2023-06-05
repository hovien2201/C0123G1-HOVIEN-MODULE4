package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategory(){
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }

}
