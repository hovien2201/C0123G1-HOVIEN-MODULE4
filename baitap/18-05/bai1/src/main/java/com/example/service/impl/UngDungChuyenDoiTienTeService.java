package com.example.service.impl;

import com.example.service.IUngDungChuyenDoiTienTeService;
import org.springframework.stereotype.Service;

@Service
public class UngDungChuyenDoiTienTeService implements IUngDungChuyenDoiTienTeService {

    @Override
    public int tinhToan(int usd,int tiGia) {
        int vnd=usd*tiGia;
        return vnd;
    }
}
