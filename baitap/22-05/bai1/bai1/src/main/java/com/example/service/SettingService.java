package com.example.service;

import com.example.Repository.ISettingRepo;
import com.example.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService implements ISettingService{
    @Autowired
    private ISettingRepo iSettingRepo;

    @Override
    public Settings getAll() {
        return iSettingRepo.getAll();
    }

    @Override
    public void update(Settings settings) {
         iSettingRepo.update(settings);
    }
}
