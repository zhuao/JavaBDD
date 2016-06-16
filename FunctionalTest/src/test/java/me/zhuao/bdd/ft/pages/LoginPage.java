package me.zhuao.bdd.ft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public String getErrorMessage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='js-flash-container']/div/div[@class='container']")));
        return errorMessage.getText();
    }
}
