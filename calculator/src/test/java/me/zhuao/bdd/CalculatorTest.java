package me.zhuao.bdd;

import me.zhuao.bdd.calculator.Calculator;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
    public void should_get_right_result_when_input_two_digits_to_plus() {
        int result = new Calculator().calculate("3+1");
        assertThat(result, is(4));
    }

    @Test
    public void should_get_6_when_input_3_multiple_2() {
        int result = new Calculator().calculate("3*2");
        assertThat(result, is(6));
    }

    @Test
    public void should_get_6_when_input_3_multiple_2_multiple_2() {
        int result = new Calculator().calculate("3*2*2");
        assertThat(result, is(12));
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

    @Test
    public void should_get_right_result_when_input_with_bracket() {
        int result = new Calculator().calculate("3*(1-1)+1");
        assertThat(result, Is.is(1));
    }

    @Test
    public void should_get_right_result_when_input_with_multiple_bracket() {
        int result = new Calculator().calculate("3*((1-1)+1)");
        assertThat(result, Is.is(3));
    }

    @Test
    public void should_get_right_result_when_input_with_multiple_bracket_in_same_level() {
        int result = new Calculator().calculate("3*(1-1)*(1+2)");
        assertThat(result, Is.is(0));
    }
}