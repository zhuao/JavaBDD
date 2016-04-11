package com.thoughtworks.bdd.ft.steps;

import com.thoughtworks.bdd.calculator.Calculator;
import com.thoughtworks.bdd.calculator.Expression;
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
