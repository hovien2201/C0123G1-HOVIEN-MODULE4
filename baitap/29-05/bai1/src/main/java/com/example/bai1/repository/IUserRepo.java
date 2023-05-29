package com.example.bai1.repository;

import com.example.bai1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {

}
