package com.thoughtworks.bdd.steps;

import com.thoughtworks.bdd.pages.HomePage;
import com.thoughtworks.bdd.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    @And("^I log in with invalid username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLogInWithUsernameAndPassword(String username, String password) {
        new LoginPage(Hooks.getDriver()).login(username, password);;
    }

    @Then("^I should login successfully$")
    public void iShouldLoginSuccessfully() {
        assertTrue(new HomePage(Hooks.getDriver()).isLoggedIn());
    }

    @Given("^I locate at login page$")
    public void iLocateAtLoginPage() throws Throwable {
        new HomePage(Hooks.getDriver()).navigateToLoginPage();
    }

    @Then("^I should see same error message \"([^\"]*)\"$")
    public void iShouldSeeSameErrorMessage(String expectedErrorMsg) throws Throwable {
        String actualErrorMsg = new LoginPage(Hooks.getDriver()).getErrorMessage();
        assertEquals(expectedErrorMsg, actualErrorMsg);
    }
}
