package com.example.bai1.model;

import javax.persistence.*;

@Entity
@Table
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codeName;
    private Boolean status;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Code() {
    }

    public Code(Integer codeName, Boolean status, Book book) {
        this.codeName = codeName;
        this.status = status;
        this.book = book;
    }

    public Code(Integer id, Integer codeName, Boolean status, Book book) {
        this.id = id;
        this.codeName = codeName;
        this.status = status;
        this.book = book;
    }

    public Code(Integer codeName) {
        this.codeName = codeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodeName() {
        return codeName;
    }

    public void setCodeName(Integer codeName) {
        this.codeName = codeName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
