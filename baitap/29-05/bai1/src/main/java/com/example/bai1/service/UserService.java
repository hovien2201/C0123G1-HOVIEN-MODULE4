package com.example.bai1.service;

import com.example.bai1.model.User;
import com.example.bai1.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class UserService implements IUserServie {
    @Autowired
    private IUserRepo iUserRepo;

    @Override
    public void save(User user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate age = LocalDate.parse(user.getAge(), formatter);
        int yearOld = Period.between(age, LocalDate.now()).getYears();
        user.setAge(String.valueOf(yearOld));
        iUserRepo.save(user);
    }
}
