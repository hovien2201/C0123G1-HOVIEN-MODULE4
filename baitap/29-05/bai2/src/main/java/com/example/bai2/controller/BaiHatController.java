package com.example.bai2.controller;

import com.example.bai2.dto.BaiHatDTO;
import com.example.bai2.model.BaiHat;
import com.example.bai2.service.IBaiHatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BaiHatController {
    @Autowired
    private IBaiHatService iBaiHatService;

    @GetMapping("/")
    public String getAll(Model model) {
        List<BaiHat> baiHatList = iBaiHatService.findAll();
        model.addAttribute("baiHatList", baiHatList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("baiHatDTO", new BaiHatDTO());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("baiHatDTO") BaiHatDTO baiHatDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new BaiHatDTO().validate(baiHatDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            redirectAttributes.addFlashAttribute("mess", "Thêm bài hát mới thành công");
            BaiHat baiHat = new BaiHat();
            BeanUtils.copyProperties(baiHatDTO, baiHat);
            iBaiHatService.save(baiHat);
            return "redirect:/";
        }
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        BaiHat baiHat = iBaiHatService.getBlogById(id);
        BaiHatDTO baiHatDTO=new BaiHatDTO();
        BeanUtils.copyProperties(baiHat, baiHatDTO);
        model.addAttribute("baiHatDTO", baiHatDTO);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute("baiHatDTO") BaiHatDTO baiHatDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new BaiHatDTO().validate(baiHatDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa bài hát  thành công");
            BaiHat baiHat = new BaiHat();
            BeanUtils.copyProperties(baiHatDTO, baiHat);
            iBaiHatService.save(baiHat);
            return "redirect:/";
        }
    }

}
