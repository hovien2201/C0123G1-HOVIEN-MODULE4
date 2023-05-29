package com.example.bai2.service;

import com.example.bai2.dto.BaiHatDTO;
import com.example.bai2.model.BaiHat;
import com.example.bai2.repository.IBaiHatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BaiHatService implements IBaiHatService{
    @Autowired
    private IBaiHatRepository iBaiHatRepository;

    @Override
    public List<BaiHat> findAll() {
        return iBaiHatRepository.findAll();
    }

    @Override
    public void save(BaiHat baiHat) {
        iBaiHatRepository.save(baiHat);
    }

    @Override
    public BaiHat getBlogById(Integer id) {
        return iBaiHatRepository.findById(id).get();
    }
}
