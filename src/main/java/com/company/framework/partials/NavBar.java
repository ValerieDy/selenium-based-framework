package com.company.framework.partials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBar {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private String signInLink = ".header_user_info a.login";
    private String logOutLink = "a.logout";

    public NavBar(WebDriver webDriver) {
        this.wait = new WebDriverWait(webDriver, 40L);
        this.webDriver = webDriver;
    }

    public void waitForNavBarLoad() {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".columns-container .container")));
    }

    public void clickSignInLink() {
        try {
            this.webDriver.findElement(By.cssSelector(signInLink)).click();
        } catch (Exception var2) {
            throw new RuntimeException("Impossible to click button", var2);
        }
    }

    public void clickSignOutLink() {
        try {
            this.webDriver.findElement(By.cssSelector(logOutLink)).click();
        } catch (Exception var2) {
            throw new RuntimeException("Impossible to click button", var2);
        }
    }
}
