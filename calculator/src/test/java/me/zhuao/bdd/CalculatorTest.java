package me.zhuao.bdd;

import me.zhuao.bdd.calculator.Calculator;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    @Test
    public void should_get_4_when_input_one_digit_4() {
        int result = new Calculator().calculate("4");
        assertThat(result, Is.is(4));
    }

    @Test
    public void should_get_4_when_input_one_digit_with_bracket() {
        int result = new Calculator().calculate("4");
        assertThat(result, Is.is(4));
    }

    @Test
    public void should_get_right_result_when_input_two_digits_to_plus() {
        int result = new Calculator().calculate("3+1");
        assertThat(result, Is.is(4));
    }

    @Test
    public void should_get_6_when_input_3_multiple_2() {
        int result = new Calculator().calculate("3*2");
        assertThat(result, Is.is(6));
    }

    @Test
    public void should_get_right_result_when_input_3_numbers_to_calculate() {
        int result = new Calculator().calculate("3+1-1");
        assertThat(result, Is.is(3));
    }

    @Test
    public void should_get_right_result_when_input_mix_calculate() {
        int result = new Calculator().calculate("3+1-1*2");
        assertThat(result, Is.is(2));
    }
}