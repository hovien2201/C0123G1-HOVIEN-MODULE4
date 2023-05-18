package com.example.controller;

import com.example.service.IUngDungChuyenDoiTienTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UngDungChuyenDoiTienTe {
    @Autowired
    private IUngDungChuyenDoiTienTeService iUngDungChuyenDoiTienTeService;


    @GetMapping("/")
    public String dieuHuong(){
        return "form";
    }
    @PostMapping("/")
    public String traKetQua(Model model, @RequestParam(value = "usd")int usd,@RequestParam(value = "tigia")int tiGia){
        int vnd= iUngDungChuyenDoiTienTeService.tinhToan(usd,tiGia);
        model.addAttribute("vnd",vnd);
        return "form";
    }
}
