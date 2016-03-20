package com.thoughtworks.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToNotificationPage() {
        driver.findElement(By.xpath("//a[@href='/notifications']")).click();
    }

    public void navigateToLoginPage() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void logout() {
        driver.findElement(By.xpath("//a[@href='/zhuao']")).click();
        driver.findElement(By.className("logout-form")).findElement(By.tagName("button")).click();
    }

    public boolean isLoggedIn() {
        return driver.findElement(By.xpath("//img[@class='avatar']")).isDisplayed();
    }
}
