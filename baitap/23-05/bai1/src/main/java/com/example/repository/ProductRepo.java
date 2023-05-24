package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.*;

import static com.example.repository.BaseRepository.entityManager;

@Repository
public class ProductRepo implements IProductRepo{

    @Override
    public List<Product> findAll() {
        List<Product> productList= entityManager.createQuery("select p from Product p order by p.id desc ", Product.class).getResultList();;
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public void update( Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public void remove(int id) {
        Product product=findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(product);
        transaction.commit();
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = entityManager.createQuery("SELECT p FROM Product p WHERE p.name like :name", Product.class)
                .setParameter("name", "%"+name+"%")
                .getResultList();
        return productList;
    }
}
