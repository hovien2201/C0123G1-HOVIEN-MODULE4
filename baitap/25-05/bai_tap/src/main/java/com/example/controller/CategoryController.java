package com.example.controller;

import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/")
    public String getAllCategory(Model model,@RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Category> categoryList = iCategoryService.findAll(page);
        model.addAttribute("categoryList", categoryList);
        return "list";
    }

    @GetMapping("/createCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @PostMapping("/saveCategory")
    public String createCategory(@ModelAttribute("category") Category category, BindingResult bindingResult, RedirectAttributes redirect) {
        category.setDelete(true);
        iCategoryService.save(category);
        redirect.addFlashAttribute("mess", "Add Category successfully");
        return "redirect:/category/";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        Category category = iCategoryService.findById(id);
        category.setDelete(false);
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "delete successfully");
        return "redirect:/category/";
    }

    @GetMapping("{id}/editCategory")
    public String editCategory(@PathVariable Integer id, Model model) {
        Category category = iCategoryService.findById(id);
        model.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping("editCategory")
    public String editCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Edit category successfully");
        return "redirect:/category/";
    }
}
