package com.thoughtworks.bdd.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.plugin2.util.SystemUtil;

public class Hooks {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void beforeScenario() {
        System.setProperty("webdriver.chrome.driver", detectDriverPath());
        driver = new ChromeDriver();
        getDriver().get("https://github.com");
    }

    private String detectDriverPath() {
        int osType = SystemUtil.getOSType();
        if (osType == SystemUtil.WINDOWS) {
            return getClass().getClassLoader().getResource("bin/windows/chromedriver.exe").getPath();
        }
        return getClass().getClassLoader().getResource("bin/mac/chromedriver").getPath();

    }

    @After
    public void afterScenario() {
        getDriver().quit();
    }
}
