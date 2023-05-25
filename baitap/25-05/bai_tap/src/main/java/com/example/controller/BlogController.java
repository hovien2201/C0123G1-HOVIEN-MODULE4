package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/")
    public String getAll(Model model) {
        List<Blog> blogList = iBlogService.getAll();
        model.addAttribute("blogList", blogList);
        return "index";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String createStudent(@ModelAttribute("blog") Blog blog, BindingResult bindingResult, RedirectAttributes redirect) {
        LocalDateTime createAt = LocalDateTime.now();
        blog.setCreateAt(createAt);
        redirect.addFlashAttribute("mess", "Add student successfully");
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
    public String search(@RequestParam("title") String title, Model model) {
        List<Blog> blogList = iBlogService.findAllByTitleContaining(title);
        model.addAttribute("blogList", blogList);
        model.addAttribute("title", title);
        return "index";
    }
}
