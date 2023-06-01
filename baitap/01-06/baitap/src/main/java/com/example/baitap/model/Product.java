package com.example.baitap.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Long price;
    private String description;
    private String img;

    public Product() {
    }

    public Product(Integer id, String name, Long price, String description, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.img = img;
    }

    public Product(String name, Long price, String description, String img) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}