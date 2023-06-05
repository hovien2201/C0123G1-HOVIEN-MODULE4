package com.example.repository;

import com.example.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByTitle(String title);
    List<Blog> findAllByCategory_CategoryId(Integer categoryId);
    @Query(value = "select b from Blog b where b.title like  concat( '%',:title,'%')")
    Page<Blog> findCategory(@Param("title") String title, Pageable pageable);
    @Query(value = "select b from Blog b where b.title like  concat( '%',:title,'%')")
    List<Blog> searchBlog(@Param("title") String title);
}
