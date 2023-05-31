package com.example.bai1.controller;

import com.example.bai1.dto.UserDTO;
import com.example.bai1.model.User;
import com.example.bai1.service.IUserServie;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserServie iUserServie;

    @GetMapping("")
    public String signup(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "index";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            redirectAttributes.addFlashAttribute("mess", "Đăng kí thành công");
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            iUserServie.save(user);
            return "redirect:/";
        }
    }
}
