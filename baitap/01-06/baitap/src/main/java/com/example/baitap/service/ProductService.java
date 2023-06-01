package com.example.baitap.service;

import com.example.baitap.model.Product;
import com.example.baitap.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return iProductRepo.findById(id);
    }

    @Override
    public Product findByIdP(Integer id) {
        return iProductRepo.findById(id).get();
    }
}
