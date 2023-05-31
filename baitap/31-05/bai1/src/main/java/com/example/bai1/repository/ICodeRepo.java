package com.example.bai1.repository;

import com.example.bai1.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodeRepo extends JpaRepository<Code,Integer> {
    Code findCodeByCodeName(Integer codeName);
}
