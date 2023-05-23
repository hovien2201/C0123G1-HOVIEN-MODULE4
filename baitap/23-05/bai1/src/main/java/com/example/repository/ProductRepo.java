package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepo implements IProductRepo{
    private static Map<Integer, Product> products;
    static {
        products=new HashMap<>();
        products.put(1,new Product(1,"Iphone",5000000,"mau trang","Apple"));
        products.put(2,new Product(2,"Samsung",2000000,"mau den","samsung"));
        products.put(3,new Product(3,"oppo",8000000,"mau vang","oppo"));
        products.put(4,new Product(4,"nokia",3000000,"mau trang","nokia"));
        products.put(5,new Product(5,"redmi",5500000,"mau den","redmi"));
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList=new ArrayList<>(products.values());
        return productList;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.replace(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        Set<Integer> set=products.keySet();
        List<Product> productList=new ArrayList<>();
        for (Integer s:set) {
            if (products.get(s).getName().equals(name)){
                productList.add(products.get(s));
            }
        }
        return productList;
    }
}
