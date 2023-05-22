package com.example.controller;

import com.example.model.Settings;
import com.example.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebAppController {
    @Autowired
    private ISettingService iSettingService;
    @GetMapping("/")
    public String directional(){
        return "index";
    }
    @GetMapping("/settings")
    public String settings(Model model){
        Settings settings=iSettingService.getAll();
        model.addAttribute("settings",settings);
        return "settings";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("settings")Settings settings,Model model){
        iSettingService.update(settings);
        model.addAttribute("result","Update successfully");
        return "index";
    }

}
