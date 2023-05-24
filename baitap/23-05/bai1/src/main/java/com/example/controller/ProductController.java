package com.example.controller;


import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;


    @GetMapping("/")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes, @ModelAttribute("product") Product product) {
        List<Product> productList=productService.findAll();
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Add new product successfully");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Delete new product successfully");
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.update( product);
        redirectAttributes.addFlashAttribute("mess", "Edit product successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> productList = productService.findByName(name);
        model.addAttribute("productList", productList);
        model.addAttribute("name", name);
        return "index";
    }
}