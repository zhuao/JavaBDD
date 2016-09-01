package me.zhuao.bdd.controller;

import org.hamcrest.MatcherAssert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class CalculatorControllerTest {

//    @Autowired
    private CalculatorController calculatorController;


    @Test
    @Ignore
    public void should_calculate_float_when_calculator_do_not_support_yet() {
        MatcherAssert.assertThat(calculatorController.calculate("1+1"), is(2));
//        assertThat(calculatorController.calculate("1.5*2"), is(3));
    }

}