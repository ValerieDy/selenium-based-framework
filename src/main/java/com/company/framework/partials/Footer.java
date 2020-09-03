package com.company.framework.partials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Footer {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private String signOutLink = ".toggle-footer a[href='http://automationpractice.com/index.php?mylogout']";
    private String footerContainer = ".footer-container";

    public Footer(WebDriver webDriver) {
        this.wait = new WebDriverWait(webDriver, 40L);
        this.webDriver = webDriver;
    }

    public void waitForFooterLoad() {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(footerContainer)));
    }

    public void clickSignOutLink() {
        try {
            this.webDriver.findElement(By.cssSelector(signOutLink)).click();
        } catch (Exception var2) {
            throw new RuntimeException("Impossible to click button", var2);
        }
    }

}
