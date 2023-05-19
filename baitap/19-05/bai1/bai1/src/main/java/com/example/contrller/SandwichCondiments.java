package com.example.contrller;

import com.example.model.Condiment;
import com.example.service.ISandwichCondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichCondiments {
    @Autowired
    ISandwichCondimentsService iSandwichCondimentsService;

    @GetMapping("/")
    public String selectSandwichCondiments() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "lettuce", defaultValue = "") String lettuce, @RequestParam(value = "tomato", defaultValue = "") String tomato, @RequestParam(value = "mustard", defaultValue = "") String mustard, @RequestParam(value = "sprouts", defaultValue = "") String sprouts, Model model) {
        Condiment condiment = new Condiment(lettuce, tomato, mustard, sprouts);
        iSandwichCondimentsService.save(condiment);
        if (lettuce != "") {
            model.addAttribute("lettuce", lettuce);
        }
        if (tomato != "") {
            model.addAttribute("tomato", tomato);
        }
        if (mustard != "") {
            model.addAttribute("mustard", mustard);
        }
        if (sprouts != "") {
            model.addAttribute("sprouts", sprouts);
        }
        return "index";
    }

}
