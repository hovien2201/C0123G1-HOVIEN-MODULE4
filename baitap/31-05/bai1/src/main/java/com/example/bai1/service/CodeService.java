package com.example.bai1.service;

import com.example.bai1.model.Code;
import com.example.bai1.repository.ICodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService implements ICodeService{
    @Autowired
    private ICodeRepo iCodeRepo;

    @Override
    public void save(Code code) {
        iCodeRepo.save(code);
    }


    @Override
    public List<Code> findAll() {
        return iCodeRepo.findAll();
    }

    @Override
    public boolean checkCodeName(Integer codeName) {
        List<Code> codeList=iCodeRepo.findAll();
        for (int i = 0; i < codeList.size(); i++) {
            if (codeList.get(i).getCodeName().equals(codeName) && codeList.get(i).getStatus()){
                return true;
            }
        }
        return false;
    }

    @Override
    public Code findByCodeName(Integer codeName) {
        return iCodeRepo.findCodeByCodeName(codeName);
    }
}
