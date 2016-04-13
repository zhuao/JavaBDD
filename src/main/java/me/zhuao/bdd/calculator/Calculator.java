package me.zhuao.bdd.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Calculator {

    @Bean
    public Calculator provideCalculator() {
        return new Calculator();
    }

    public int calculate(String expression) {
        return new Expression(expression.replace(" ", "")).value();
    }

}
