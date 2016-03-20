package com.thoughtworks.bdd.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class CalculatorSteps {

    private int result;

    @When("^I add (\\d+) and (\\d+)$")
    public void iAddAnd(int arg0, int arg1) throws Throwable {
        result = arg0 + arg1;
    }

    @Given("^I turn on the calculator$")
    public void iTurnOnTheCalculator() throws Throwable {
        result = 0;
    }

    @Then("^The result is (\\d+)$")
    public void theResultIs(int expectedResult) throws Throwable {
        assertEquals(expectedResult, result);
    }
}
