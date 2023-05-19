package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public double calculate(Double number1, Double number2, String calculation) {
        double result=0;
        switch (calculation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "x":
                result = number1 * number2;
                break;
            case "/":
                result = number1/number2;
                break;
        }
        return result;
    }
}
