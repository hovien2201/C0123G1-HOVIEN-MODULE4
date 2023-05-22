package com.example.controller;

import com.example.model.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WebApp {
    @GetMapping("/")
    public String directional(){
        return "index";
    }
    @GetMapping("/settings")
    public String settings(Model model){
        model.addAttribute("setting",new Settings());
        return "settings";
    }

}
