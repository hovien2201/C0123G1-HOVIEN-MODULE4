package com.example.repository.impl;

import com.example.model.Condiment;
import com.example.repository.ISandwichCondimentsRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SandwichCondimentsRepo implements ISandwichCondimentsRepo {
    private static List<Condiment> condiments= new ArrayList<>();
    static {
        condiments.add(new Condiment("Lettuce","Tomato","null","null"));
    }

    @Override
    public void save(Condiment condiment) {
        condiments.add(condiment);
    }
}
