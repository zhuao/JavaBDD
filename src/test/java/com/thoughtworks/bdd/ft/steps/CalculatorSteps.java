package com.thoughtworks.bdd.ft.steps;

import com.thoughtworks.bdd.Calculator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class CalculatorSteps {

    private Calculator calculator;

    @Given("^I turn on the calculator$")
    public void iTurnOnTheCalculator() {
        calculator = null;
    }

    @When("^I input expression \"([^\"]*)\"$")
    public void iInputExpression(String expression) {
        calculator = new Calculator(expression);
    }

    @Then("^The result is (\\d+)$")
    public void theExpectedResultIs(int expectedResult) {
        assertEquals(expectedResult, calculator.calculate());
    }
}
