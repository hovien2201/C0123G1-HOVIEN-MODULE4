package com.example.controller;

import com.example.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICaculatorService iCaculatorService;

    @GetMapping("/")
    public String getForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("number1") Double number1, @RequestParam("number2") Double number2, @RequestParam("calculation") String calculation, Model model) {
        double result = iCaculatorService.calculate(number1, number2, calculation);
        if (number1 == 0 && calculation.equals("/")) {
            model.addAttribute("result", "0 cannot be divided");
        } else {
            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            model.addAttribute("result", (double) Math.round(result * 10) / 10);
        }
        return "index";
    }
}
