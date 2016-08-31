package me.zhuao.bdd.calculator;

public class Calculator {

    public int calculate(String expression) {
        return new Expression(expression.replace(" ", "")).value();
    }

}
