package com.example.service.impl;

import com.example.model.Condiment;
import com.example.repository.ISandwichCondimentsRepo;
import com.example.service.ISandwichCondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichCondimentsService implements ISandwichCondimentsService {
    @Autowired
    ISandwichCondimentsRepo iSandwichCondimentsRepo;

    @Override
    public void save(Condiment condiment) {
        iSandwichCondimentsRepo.save(condiment);
    }
}
