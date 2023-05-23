package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public List<Product> findAll() {
        List<Product> products = iProductRepo.findAll();
        return products;
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepo.update(id, product);
    }

    @Override
    public void remove(int id) {
        iProductRepo.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepo.findByName(name);
    }
}
