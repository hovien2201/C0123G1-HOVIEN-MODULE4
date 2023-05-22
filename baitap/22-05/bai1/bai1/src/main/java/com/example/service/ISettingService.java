package com.example.service;

import com.example.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;

public interface ISettingService {
    Settings getAll();

    void update(Settings settings);
}
