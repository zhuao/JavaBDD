package com.thoughtworks.bdd;

public class Expression {
    private String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public int value() {
        int startBracketIndex = expression.indexOf('(');
        if (startBracketIndex != -1) {
            for (int charIndex = startBracketIndex + 1; charIndex < expression.length(); charIndex++) {
                int depth = 0;
                if (expression.indexOf(charIndex) == '(') {
                    depth++;
                } else if (expression.indexOf(charIndex) == ')') {
                    if (depth == 0) {

                    }
                }
            }
        }

        int indexOfPlus = expression.indexOf("+");
        if (indexOfPlus == -1) {
            int indexOfMinus = expression.indexOf("-");
            if (indexOfMinus == -1) {
                return Integer.valueOf(expression);
            } else {
                return new Expression(expression.substring(0, indexOfMinus)).value() - new Expression(expression.substring(indexOfMinus + 1)).value();
            }
        } else {
            return new Expression(expression.substring(0, indexOfPlus)).value() + new Expression(expression.substring(indexOfPlus + 1)).value();
        }
    }

}
