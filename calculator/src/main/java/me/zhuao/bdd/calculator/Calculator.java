package me.zhuao.bdd.calculator;

public class Calculator {

    public Calculator provideCalculator() {
        return new Calculator();
    }

    public int calculate(String expression) {
        return new Expression(expression.replace(" ", "")).value();
    }

}
