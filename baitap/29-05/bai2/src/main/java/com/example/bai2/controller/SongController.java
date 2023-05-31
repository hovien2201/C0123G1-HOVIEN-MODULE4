package com.example.bai2.controller;

import com.example.bai2.dto.SongDTO;
import com.example.bai2.model.Song;
import com.example.bai2.service.ISongService;
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
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
    public String getAll(Model model) {
        List<Song> songList = iSongService.findAll();
        model.addAttribute("baiHatList", songList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("baiHatDTO", new SongDTO());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("baiHatDTO") SongDTO baiHatDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongDTO().validate(baiHatDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(baiHatDTO, song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("mess", "Thêm bài hát mới thành công");
            return "redirect:/";
        }
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Song song = iSongService.getBlogById(id);
        SongDTO songDTO=new SongDTO();
        BeanUtils.copyProperties(song, songDTO);
        model.addAttribute("baiHatDTO", songDTO);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute("baiHatDTO") SongDTO baiHatDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongDTO().validate(baiHatDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(baiHatDTO, song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa bài hát  thành công");
            return "redirect:/";
        }
    }

}
