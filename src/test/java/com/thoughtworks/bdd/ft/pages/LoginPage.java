package com.thoughtworks.bdd.ft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.id("login_field")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

    public boolean isDisplayedErrorMessage() {
        String errorMsg = driver.findElement(By.xpath(".//*[@id='js-flash-container']/div/div[@class='container']")).getText();
        return "Incorrect username or password.".equals(errorMsg.trim());
    }

    public String getErrorMessage() {
        return driver.findElement(By.xpath(".//*[@id='js-flash-container']/div/div[@class='container']")).getText();
    }
}
