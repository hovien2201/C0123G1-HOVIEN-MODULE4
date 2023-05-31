package com.example.bai1.service;

import com.example.bai1.model.Book;
import com.example.bai1.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepo iBookRepo;

    @Override
    public List<Book> getAll() {
        return iBookRepo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepo.findById(id).get();
    }

    @Override
    public boolean save(Book book) {
        int quantity=book.getQuantity()-1;
        if (quantity<0){
            return false;
        }else {
            book.setQuantity(quantity);
            iBookRepo.save(book);
            return true;
        }

    }

    @Override
    public void saveBook(Book book) {
        iBookRepo.save(book);
    }
}
