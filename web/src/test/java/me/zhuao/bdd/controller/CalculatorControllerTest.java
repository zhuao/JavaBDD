package me.zhuao.bdd.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CalculatorControllerTest {

    @Autowired
    private CalculatorController calculatorController;


    @Test
    public void should_calculate_float_when_calculator_do_not_support_yet() {
        assertThat(calculatorController.calculate("1+1"), is(2));
//        assertThat(calculatorController.calculate("1.5*2"), is(3));
    }

}