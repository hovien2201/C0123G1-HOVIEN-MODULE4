package com.example.bai1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Aspect
@Component
public class BookAspect {
    private static int count = 0;

    @After("execution(* com.example.bai1.controller.BookController.*(..))")
    public void log(JoinPoint joinPoint) throws IOException {

        File file = new File("F:\\codegym\\module4\\C0123G1-HOVIEN-MODULE4\\baitap\\31-05\\bai1\\src\\main\\java\\com\\example\\bai1\\log\\log.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(joinPoint.getSignature().getName());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterReturning(value = "execution(* com.example.bai1.controller.BookController.*(..))", returning = "result")
    public void logBorrow(JoinPoint joinPoint, Object result) {
        File file = new File("F:\\codegym\\module4\\C0123G1-HOVIEN-MODULE4\\baitap\\31-05\\bai1\\src\\main\\java\\com\\example\\bai1\\log\\visit.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(joinPoint.getSignature().getName());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After(value = "execution(* com.example.bai1.controller.BookController.*(..))")
    public void logUserVisit(JoinPoint joinPoint) {
        File file = new File("F:\\codegym\\module4\\C0123G1-HOVIEN-MODULE4\\baitap\\31-05\\bai1\\src\\main\\java\\com\\example\\bai1\\log\\visit.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        count++;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(count);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}