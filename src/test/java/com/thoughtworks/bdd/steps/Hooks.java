package com.thoughtworks.bdd.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void beforeScenario() {
        driver = new FirefoxDriver();
        getDriver().get("https://github.com");
    }

    @After
    public void afterScenario() {
        getDriver().quit();
    }
}
