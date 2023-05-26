package com.example.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", columnDefinition = "VARCHAR(100)")
    @NonNull
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    @NonNull
    private String content;

    @Column(name = "createAt", columnDefinition = "DATETIME")
    @NonNull
    private LocalDateTime createAt;

    @Column(name = "updateAt", columnDefinition = "DATETIME")
    private LocalDateTime updateAt;

    @Column(name = "author", columnDefinition = "VARCHAR(50)")
    @NonNull
    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(@NonNull String title, @NonNull String content, @NonNull LocalDateTime createAt, LocalDateTime updateAt, @NonNull String author) {
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.author = author;
    }

    public Blog(Integer id, @NonNull String title, @NonNull String content, @NonNull LocalDateTime createAt, LocalDateTime updateAt, @NonNull String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.author = author;
    }

    public Blog(Integer id, @NonNull String title, @NonNull String content, @NonNull LocalDateTime createAt, LocalDateTime updateAt, @NonNull String author, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.author = author;
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime dayCreate) {
        this.createAt = dayCreate;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime dayUpdate) {
        this.updateAt = dayUpdate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
