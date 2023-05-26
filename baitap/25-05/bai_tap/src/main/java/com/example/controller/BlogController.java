package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/")
    public String getAll(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Blog> blogList = iBlogService.getAll(page);
        model.addAttribute("blogList", blogList);
        return "index";
    }


    @GetMapping("/create")
    public String addBlog(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryList);
        return "create";
    }

    @PostMapping("/save")
    public String createBlog(@ModelAttribute("blog") Blog blog, BindingResult bindingResult, RedirectAttributes redirect) {
        LocalDateTime createAt = LocalDateTime.now();
        blog.setCreateAt(createAt);
        redirect.addFlashAttribute("mess", "Add Blog successfully");
        iBlogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "delete successfully");
        return "redirect:/";
    }


    @GetMapping("/{id}/view")
    public String detailByPathVariable(@PathVariable("id") Integer id,
                                       Model model) {
        Blog blog = iBlogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Blog blog = iBlogService.getBlogById(id);
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blog.setUpdateAt(LocalDateTime.now());
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit product successfully");
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam("title") String title, Model model,@RequestParam(value = "page", defaultValue = "0") int page) {
        List<Blog> blogList = iBlogService.findAllByTitle(title);
        model.addAttribute("blogList", blogList);
        model.addAttribute("title", title);
        return "index";
    }
}
