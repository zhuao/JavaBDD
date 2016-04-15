package me.zhuao.bdd.controller;

import me.zhuao.bdd.calculator.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private Calculator calculator;


    @RequestMapping("/calculate")
    public int calculate(@RequestParam String expression) {
        return calculator.calculate(expression);
    }

    @Bean
    public Calculator createCalculator() {
        return new Calculator();
    }
}
