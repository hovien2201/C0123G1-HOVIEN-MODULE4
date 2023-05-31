package com.example.bai1.service;

import com.example.bai1.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    Book findById(Integer id);

    boolean save(Book book);

    void saveBook(Book book);
}
