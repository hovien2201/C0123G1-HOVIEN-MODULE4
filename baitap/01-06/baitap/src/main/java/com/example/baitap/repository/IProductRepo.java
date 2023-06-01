package com.example.baitap.repository;

import com.example.baitap.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product,Integer> {
}
