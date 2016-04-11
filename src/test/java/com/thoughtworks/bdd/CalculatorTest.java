package com.thoughtworks.bdd;

import com.thoughtworks.bdd.calculator.Calculator;
import com.thoughtworks.bdd.calculator.Expression;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    @Test
    public void should_get_4_when_input_one_digit_4() {
        int result = new Calculator().calculate("4");
        assertThat(result, is(4));
    }

    @Test
    public void should_get_4_when_input_one_digit_with_bracket() {
        int result = new Calculator().calculate("4");
        assertThat(result, is(4));
    }

    @Test
    public void should_get_3_when_input_3_plus_1() {
        int result = new Calculator().calculate("3+1");
        assertThat(result, is(4));
    }

    @Test
    public void should_get_6_when_input_3_multiple_2() {
        int result = new Calculator().calculate("3*2");
        assertThat(result, is(6));
    }

    @Test
    public void should_get_right_result_when_input_3_numbers_to_calculate() {
        int result = new Calculator().calculate("3+1-1");
        assertThat(result, is(3));
    }

    @Test
    public void should_get_right_result_when_input_mix_calculate() {
        int result = new Calculator().calculate("3+1-1*2");
        assertThat(result, is(2));
    }
}