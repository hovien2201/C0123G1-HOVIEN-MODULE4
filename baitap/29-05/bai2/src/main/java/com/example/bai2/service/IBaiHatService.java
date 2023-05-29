package com.example.bai2.service;


import com.example.bai2.dto.BaiHatDTO;
import com.example.bai2.model.BaiHat;

import java.util.List;

public interface IBaiHatService {

    List<BaiHat> findAll();

    void save(BaiHat baiHat);

    BaiHat getBlogById(Integer id);
}
