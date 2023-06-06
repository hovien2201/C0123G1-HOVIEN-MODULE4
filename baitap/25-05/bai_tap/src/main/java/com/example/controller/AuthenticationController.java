package com.example.controller;

import com.example.model.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class AuthenticationController {
    @ModelAttribute("user")
    public AppUser setUpUserForm() {
        return new AppUser();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        return "login";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
}