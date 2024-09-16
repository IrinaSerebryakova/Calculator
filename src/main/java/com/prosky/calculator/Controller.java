package com.prosky.calculator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    private final CalculatorServiceImpl calculatorService;
    public Controller(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }
    @RequestMapping (path="/calculator")
    public String welcome() {
        return calculatorService.welcome();
    }
    @RequestMapping (path="/calculator/plus")
    public String plus(int num1, int num2){
        return calculatorService.plus(num1, num2);
    }

    @RequestMapping (path="/calculator/minus")
    public String minus(int num1, int num2){
        return calculatorService.minus(num1, num2);
    }

    @RequestMapping (path="/calculator/multiply")
    public String multiply(int num1, int num2){
        return calculatorService.multiply(num1, num2);
    }

    @RequestMapping (path="/calculator/divide")
    public String divide(int num1, int num2){
        return calculatorService.divide(num1, num2);
    }
}
