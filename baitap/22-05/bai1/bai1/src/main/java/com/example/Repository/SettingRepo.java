package com.example.Repository;

import com.example.model.Settings;
import org.springframework.stereotype.Repository;

@Repository
public class SettingRepo implements ISettingRepo{
    private static Settings settings=new Settings("English",25,true,"Thor");

    @Override
    public Settings getAll() {
        return settings;
    }

    @Override
    public void update(Settings settings1) {
        settings=settings1;
    }
}
