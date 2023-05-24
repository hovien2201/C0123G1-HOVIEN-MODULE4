package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",columnDefinition = "VARCHAR(50)",nullable =true)
    private String name;

    private int price;
    private String description;
    private String manufacture;

    public Product() {
    }

    public Product(String name, int price, String description, String manufacture) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
    }

    public Product(int id, String name, int price, String describe, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = describe;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
