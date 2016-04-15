package me.zhuao.bdd.ft.steps;

import me.zhuao.bdd.calculator.Calculator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class CalculatorSteps {

    private Calculator calculator;
    private String expression;

    @Given("^I turn on the calculator$")
    public void iTurnOnTheCalculator() {
        calculator = null;
    }

    @When("^I input expression \"([^\"]*)\"$")
    public void iInputExpression(String expression) {
        this.expression = expression;
        calculator = new Calculator();
    }

    @Then("^The result is (\\d+)$")
    public void theExpectedResultIs(int expectedResult) {
        assertEquals(expectedResult, calculator.calculate(expression));
    }
}
