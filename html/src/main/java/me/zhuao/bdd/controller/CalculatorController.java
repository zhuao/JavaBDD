package me.zhuao.bdd.controller;

import me.zhuao.bdd.domain.History;
import me.zhuao.bdd.repository.HistoryRepository;
import me.zhuao.bdd.calculator.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculatorController {

    @Autowired
    private Calculator calculator;

    @Autowired
    private HistoryRepository historyRepository;


    @RequestMapping("/calculate")
    public int calculate(@RequestParam String expression) {
        int result = calculator.calculate(expression);
        historyRepository.save(new History(expression, String.valueOf(result)));
        return result;
    }

    @RequestMapping("/history")
    public List<History> history() {
        return historyRepository.findAll();
    }

    @Bean
    public Calculator createCalculator() {
        return new Calculator();
    }

}
