package me.zhuao.bdd.ft.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before("@web")
    public void beforeScenario() throws Exception {
        driver = new FirefoxDriver();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        getDriver().get("https://github.com");
    }

    @After("@web")
    public void afterScenario() {
        getDriver().quit();
    }
}
