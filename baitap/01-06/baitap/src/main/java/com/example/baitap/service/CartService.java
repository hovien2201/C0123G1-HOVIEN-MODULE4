package com.example.baitap.service;

import com.example.baitap.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService implements ICartService{


    public boolean checkItemInCart(Product product,Map<Product,Integer> cart){
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }



    public Map.Entry<Product, Integer> selectItemInCart(Product product,Map<Product,Integer> cart){
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product,Map<Product,Integer> cart){
        if (!checkItemInCart(product,cart)){
            cart.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product,cart);
            Integer newQuantity = itemEntry.getValue() + 1;
            cart.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Integer countProductQuantity(Map<Product,Integer> cart){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(Map<Product,Integer> cart){
        return cart.size();
    }

    public Float countTotalPayment(Map<Product,Integer> cart){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
    public void removeProduct(Product product,Map<Product,Integer> cart){
        if (!checkItemInCart(product,cart)){
            cart.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product,cart);
            if (itemEntry.getValue()>0){
            Integer newQuantity = itemEntry.getValue() - 1;
                cart.replace(itemEntry.getKey(),newQuantity);
            }else {
                cart.remove(product);
            }
        }
    }
}
