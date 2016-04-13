package me.zhuao.bdd.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private String expression;
    public static final Pattern TWO_VARIABLE_SIMPLE_EXPRESS = Pattern.compile("(([0-9]+)[\\+\\-]([0-9]+)).*");
    public static final Pattern TWO_VARIABLE_EXPRESS = Pattern.compile(".*(([0-9]+)[\\*\\/]([0-9]+)).*");

    public Expression(String expression) {
        this.expression = expression;
    }

    public int value() {

        expression = calculateBraketRegression(expression);

        expression = calculateMultiple(expression);

        expression = calculateSUM(expression);

        return Integer.valueOf(expression);
    }

    private String calculateBraketRegression(String expression) {
        int startBracketIndex = expression.indexOf('(');
        while (startBracketIndex != -1) {
            int depth = 0;
            for (int charIndex = startBracketIndex + 1; charIndex < expression.length(); charIndex++) {
                if (expression.charAt(charIndex) == '(') {
                    depth++;
                } else if (expression.charAt(charIndex) == ')') {
                    if (depth == 0) {
                        int value = new Expression(expression.substring(startBracketIndex + 1, charIndex)).value();
                        expression = expression.substring(0, startBracketIndex) + value + expression.substring(charIndex + 1, expression.length());
                        break;
                    } else {
                        depth--;
                    }
                }

            }
            startBracketIndex = expression.indexOf('(');
        }
        return expression;
    }

    private String calculateMultiple(String expression) {
        Matcher matcher = TWO_VARIABLE_EXPRESS.matcher(expression);
        if (matcher.matches()) {
            int subExpressionResult = 0;
            if (expression.charAt(matcher.end(2)) == '*') {
                subExpressionResult = Integer.valueOf(matcher.group(2)) * Integer.valueOf(matcher.group(3));
            } else {
                subExpressionResult = Integer.valueOf(matcher.group(2)) / Integer.valueOf(matcher.group(3));
            }
            String s1 = expression.substring(0, matcher.start(2)) + subExpressionResult + expression.substring(matcher.end(3), expression.length());
            return calculateSUM(s1);
        } else {
            return expression;
        }
    }

    private String calculateSUM(String expression) {
        Matcher matcher = TWO_VARIABLE_SIMPLE_EXPRESS.matcher(expression);
        if (matcher.matches()) {
            int subExpressionResult = 0;
            if (expression.charAt(matcher.end(2)) == '+') {
                subExpressionResult = Integer.valueOf(matcher.group(2)) + Integer.valueOf(matcher.group(3));
            } else {
                subExpressionResult = Integer.valueOf(matcher.group(2)) - Integer.valueOf(matcher.group(3));
            }
            String s1 = expression.substring(0, matcher.start(2)) + subExpressionResult + expression.substring(matcher.end(3), expression.length());
            return calculateSUM(s1);
        } else {
            return expression;
        }

    }

}
