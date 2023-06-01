package com.example.baitap.service;

import com.example.baitap.model.Product;

import java.util.Map;

public interface ICartService {
    boolean checkItemInCart(Product product,Map<Product,Integer> cart);
    Map.Entry<Product, Integer> selectItemInCart(Product product,Map<Product,Integer> cart);
    void addProduct(Product product,Map<Product,Integer> cart);
    Integer countProductQuantity(Map<Product,Integer> cart);
    Integer countItemQuantity(Map<Product,Integer> cart);
    Float countTotalPayment(Map<Product,Integer> cart);
    void removeProduct(Product product,Map<Product,Integer> cart);
}
