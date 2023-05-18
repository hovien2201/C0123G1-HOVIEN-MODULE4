package com.example.bai2.service.impl;

import com.example.bai2.repository.IUngDungTuDienRepo;
import com.example.bai2.service.IUngdungTuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UngDungTuDienService implements IUngdungTuDienService {
    @Autowired
    IUngDungTuDienRepo iUngDungTuDienRepo;

    @Override
    public String traCuu(String english) {
        String str = iUngDungTuDienRepo.traCuu(english);
        return str;
    }
}
