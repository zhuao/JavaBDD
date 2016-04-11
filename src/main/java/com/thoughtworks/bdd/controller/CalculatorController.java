package com.thoughtworks.bdd.controller;

import com.thoughtworks.bdd.calculator.Calculator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private Calculator calculator;


    @RequestMapping("/calculate")
    public int calculate(@RequestParam String expression) {
        logger.info("AoAo, calculate");
        return calculator.calculate(expression);
    }
}
