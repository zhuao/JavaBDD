package com.thoughtworks.bdd.steps;

import com.thoughtworks.bdd.pages.HomePage;
import com.thoughtworks.bdd.pages.NotificationPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class NotificationManagementSteps {
    private FirefoxDriver driver;

    @Before
    public void beforeScenario() {
        driver = new FirefoxDriver();
        driver.get("https://github.com");
    }

    @When("^I click notification icon on the right top$")
    public void iClickNotificationIconOnTheRightTop() throws Throwable {
        new HomePage(driver).navigateToNotificationPage();
    }

    @Then("^I should see (\\d+) unread notifications$")
    public void iShouldSeeUnreadNotifications(int notificationCount) throws Throwable {
        assertEquals(new NotificationPage(driver).getUnreadCount(), notificationCount);
    }

    @Then("^I should see (\\d+) participation notifications$")
    public void iShouldSeeParticipationNotifications(int participatingCount) throws Throwable {
        assertEquals(new NotificationPage(driver).getParticipatingCount(), participatingCount);
    }

    @After
    public void afterScenario() {
        new HomePage(driver).logout();
        driver.quit();
    }

}
