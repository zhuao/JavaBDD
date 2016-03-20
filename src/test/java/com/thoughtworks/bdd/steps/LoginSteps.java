package com.thoughtworks.bdd.steps;

import com.thoughtworks.bdd.pages.HomePage;
import com.thoughtworks.bdd.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;

    @Before
    public void beforeScenario() {
        driver = new FirefoxDriver();
        driver.get("https://github.com");
    }

    @Given("^I open login page$")
    public void iOpenLoginPage(){
        new HomePage(driver).navigateToLoginPage();
    }

    @When("^I log in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLogInWithUsernameAndPassword(String username, String password) {
        new LoginPage(driver).login(username, password);;
    }

    @Then("^I should login successfully$")
    public void iShouldLoginSuccessfully() {
        assertTrue(new HomePage(driver).isLoggedIn());
    }

    @After
    public void afterScenario() {
        driver.quit();
    }
}
