package com.thoughtworks.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationPage {
    private WebDriver driver;

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getUnreadCount() {
        WebElement unreadElement = driver.findElement(By.xpath(".//*[@id='notification-center']/div[2]/div[1]/ul[1]/li[1]/a"));

        String count = unreadElement.findElement(By.className("count")).getText();
        return Integer.valueOf(count.trim());
    }

    public int getParticipatingCount() {
        WebElement unreadElement = driver.findElement(By.xpath(".//*[@id='notification-center']/div[2]/div[1]/ul[1]/li[2]/a"));
        String count = unreadElement.findElement(By.className("count")).getText();
        return Integer.valueOf(count.trim());
    }
}
