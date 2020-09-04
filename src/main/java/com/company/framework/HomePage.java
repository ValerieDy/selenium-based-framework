package com.company.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private String homeSlider = "ul#homeslider";

    public HomePage(WebDriver webDriver) {
        this.wait = new WebDriverWait(webDriver, 40L);
        this.webDriver = webDriver;
    }

    public void waitForHomePageLoad() {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(homeSlider)));
    }
}
