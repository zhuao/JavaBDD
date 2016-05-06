package me.zhuao.bdd.controller;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorControllerTestngTest {

//    @Test
    public void should_() {
        FirefoxDriver driver = new FirefoxDriver();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        driver.get("https://github.com");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login_field")).sendKeys("zhuao");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.name("commit")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='js-flash-container']/div/div[@class='container']")));
        assertThat(errorMessage.getText(), is("Incorrect username or password."));

    }
}
