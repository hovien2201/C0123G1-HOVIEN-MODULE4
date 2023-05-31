package com.example.bai2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO implements Validator {
    private Integer id;
    @Size(max = 45, message = "Tên bài hát không được quá 800 kí tự !")
    @NotBlank(message = "Tên bài hát không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên bài hát không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String title;
    @NotBlank(message = "Thể loại nhạc không được để trống")
    @Size(max = 1000, message = "Thể loại nhạc không được 1000 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9, ]+$", message = "Thể loại nhạc không chứa các kí tự đặc biệt như @;,.=-+,....Nhưng cho dấu ','")
    private String category;
    @NotBlank(message = "Tên nghệ sĩ không được để trống")
    @Size(max = 300, message = "Tên nghệ sĩ không được 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên nghệ sĩ không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String author;


    public SongDTO() {
    }

    public SongDTO(Integer id, String title, String category, String author) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
