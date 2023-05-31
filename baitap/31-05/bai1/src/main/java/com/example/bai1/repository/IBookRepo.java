package com.example.bai1.repository;

import com.example.bai1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book,Integer> {
}
