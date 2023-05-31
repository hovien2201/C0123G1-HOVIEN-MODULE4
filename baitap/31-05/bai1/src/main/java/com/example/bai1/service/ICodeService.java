package com.example.bai1.service;

import com.example.bai1.model.Code;

import java.util.List;

public interface ICodeService {
    void save(Code code);

    List<Code> findAll();

    boolean checkCodeName(Integer codeName);

    Code findByCodeName(Integer codeName);
}
