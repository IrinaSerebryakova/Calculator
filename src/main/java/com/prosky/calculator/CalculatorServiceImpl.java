package com.prosky.calculator;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private CalculatorServiceImpl calculatorService;

    public void Controller(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public String plus(@RequestParam Integer num1, @RequestParam Integer num2) {
        return String.format("%d + %d = %d", num1, num2, num1 + num2);
    }

    @Override
    public String minus(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (Integer.toString(num1).equals("") || Integer.toString(num2).equals("")) {
            return "Error";
        }
        return String.format("%d - %d = %d", num1, num2, num1 - num2);
    }

    @Override
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (Integer.toString(num1).equals("") || Integer.toString(num2).equals("")) {
            return "Error";
        }
        return String.format("%d * %d = %d", num1, num2, num1 * num2);
    }

    @Override
    public String divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num2 == 0) {
            return "Error";
        } else if (num1 != 0 && num2 != 0) {

        }
        return String.format("%d / %d = %d", num1, num2, num1 / num2);
    }
}