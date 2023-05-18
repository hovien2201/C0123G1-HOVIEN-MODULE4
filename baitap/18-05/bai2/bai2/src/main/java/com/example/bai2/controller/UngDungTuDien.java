package com.example.bai2.controller;

import com.example.bai2.service.IUngdungTuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UngDungTuDien {
    @Autowired
    IUngdungTuDienService iUngdungTuDienService;

    @GetMapping("/")
    public String dieuHuong() {
        return "index";
    }

    @PostMapping("/tra")
    public String traCuu(@RequestParam("english") String english, Model model) {
        String vietnamese = iUngdungTuDienService.traCuu(english);
        model.addAttribute("vietnamese", vietnamese);
        model.addAttribute("english", english);
        return "index";
    }
}
