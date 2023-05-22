package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {

    @GetMapping("/")
    public String selectSandwichCondiments() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "spice", defaultValue = "") String[] spice,  Model model) {
        model.addAttribute("spice",spice);
        return "index";
    }

}
