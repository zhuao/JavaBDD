package me.zhuao.bdd.controller;

import me.zhuao.bdd.calculator.Calculator;
import me.zhuao.bdd.calculator.Expression;
import mockit.*;
import org.hamcrest.MatcherAssert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

@Ignore
public class CalculatorControllerJmockitTest {

    @Tested
    private CalculatorController calculatorController;


    @Test
    public void should_calculate_float_when_calculator_do_not_support_yet(@Injectable final Calculator calculator) {
        new Expectations() {{
            calculator.calculate(anyString); result = 3;
        }};

        MatcherAssert.assertThat(calculatorController.calculate("1.5*2"), is(3));
    }

    @Test
    public void should_check_mock_method(@Injectable final Calculator calculator) {

        new MockUp<Expression>() {

            @Mock
            public int value() {
                return 2;
            }
        };

        new Expectations() {{
            calculator.calculate(anyString); result = new Expression("").value();
        }};

        MatcherAssert.assertThat(calculatorController.calculate("2+3"), is(2));
    }
}