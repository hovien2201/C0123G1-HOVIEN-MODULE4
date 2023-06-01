package com.example.baitap.service;

import com.example.baitap.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Integer id);

    Product findByIdP(Integer id);
}
