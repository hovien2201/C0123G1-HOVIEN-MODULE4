package com.example.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @NonNull
    private String categoryName;

    private Boolean isDelete;

    public Category(Integer categoryId, @NonNull String categoryName, Boolean isDelete) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.isDelete = isDelete;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Category() {
    }

//    public Category(Integer id, String categoryName) {
//        this.categoryId = id;
//        this.categoryName = categoryName;
//    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer id) {
        this.categoryId = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
