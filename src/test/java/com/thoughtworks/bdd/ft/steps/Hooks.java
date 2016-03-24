package com.thoughtworks.bdd.ft.steps;

import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

//    @Before
//    public void beforeScenario() {
//        driver = new FirefoxDriver();
//        getDriver().get("https://github.com");
//    }
//
//    @After
//    public void afterScenario() {
//        getDriver().quit();
//    }
}
