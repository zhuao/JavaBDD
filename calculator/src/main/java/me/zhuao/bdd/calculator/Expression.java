package me.zhuao.bdd.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private String expression;
    public static final Pattern TWO_VARIABLE_SIMPLE_EXPRESS = Pattern.compile("(([0-9]+)[\\+\\-]([0-9]+)).*");
    public static final Pattern TWO_VARIABLE_EXPRESS = Pattern.compile(".*(([0-9]+)[\\*\\/]([0-9]+)).*");
    public static final Pattern bracket_EXPRESS = Pattern.compile(".*\\(([0-9\\*\\/\\+\\-]+)\\).*");

    public Expression(String expression) {
        this.expression = expression;
    }

    public int value() {

        Matcher bracketMatcher = bracket_EXPRESS.matcher(expression);
        if (bracketMatcher.matches()) {
            return toBracketExpression(bracketMatcher, expression).value();
        }

        Matcher plusMatcher = TWO_VARIABLE_EXPRESS.matcher(expression);
        if (plusMatcher.matches()) {
            return toPlusNextExpression(plusMatcher, expression).value();
        }

        Matcher sumMatcher = TWO_VARIABLE_SIMPLE_EXPRESS.matcher(expression);
        if (sumMatcher.matches()) {
            return toPlusNextExpression(sumMatcher, expression).value();
        }

        return Integer.valueOf(expression);
    }

    private Expression toPlusNextExpression(Matcher plusMatcher, String expression) {
        int  subExpressionResult = calculate(Integer.valueOf(plusMatcher.group(2)), Integer.valueOf(plusMatcher.group(3)), expression.charAt(plusMatcher.end(2)));
        return new Expression(expression.substring(0, plusMatcher.start(2)) + subExpressionResult + expression.substring(plusMatcher.end(3), expression.length()));
    }

    private Expression toBracketExpression(Matcher bracketMatcher, String expression) {
        int value = new Expression(bracketMatcher.group(1)).value();
        return new Expression(expression.substring(0, bracketMatcher.start(1) - 1) + value + expression.substring(bracketMatcher.end(1) + 1, expression.length()));
    }

    private int calculate(Integer firstValue, Integer secondValue, char operator) {
        int subExpressionResult = 0;
        if (operator == '+') {
            subExpressionResult = firstValue + secondValue;
        } else if (operator == '-') {
            subExpressionResult = firstValue - secondValue;
        } else if (operator == '*') {
            subExpressionResult = firstValue * secondValue;
        } else if (operator == '/') {
            subExpressionResult = firstValue / secondValue;
        }
        return subExpressionResult;
    }

}
