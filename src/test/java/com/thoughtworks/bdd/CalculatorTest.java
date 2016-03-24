package com.thoughtworks.bdd;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_get_4_when_input_one_digit_4() {
        int result = new Calculator("4").calculate();
        assertThat(result, is(4));
    }

    @Test
    @Ignore
    public void should_get_4_when_input_one_digit_with_bracket() {
        int result = new Calculator("(4)").calculate();
        assertThat(result, is(4));
    }

    @Test
    public void should_get_3_when_input_3_plus_1() {
        int result = new Calculator("3+1").calculate();
        assertThat(result, is(4));
    }

    @Test
    public void should_get_right_result_when_input_3_numbers_to_calculate() {
        int result = new Calculator("3+1-1").calculate();
        assertThat(result, is(3));
    }

}