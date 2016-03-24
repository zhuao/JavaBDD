package com.thoughtworks.bdd;

public class Calculator {
    private final Expression expression;

    public Calculator(String expression) {
        this.expression = new Expression(expression.replace(" ", ""));
    }

    public int calculate() {
        return expression.value();
    }
}
