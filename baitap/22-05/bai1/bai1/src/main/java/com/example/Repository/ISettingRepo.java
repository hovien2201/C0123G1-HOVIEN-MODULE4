package com.example.Repository;

import com.example.model.Settings;

public interface ISettingRepo {
    Settings getAll();

    void update(Settings settings);
}
