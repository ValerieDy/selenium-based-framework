package com.company.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class LoginPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private String emailField = "input#email";
    private String passwordField = "input#passwd";
    private String loginForm = "#login_form";
    private String signInButton = "button#SubmitLogin";


//    public static ExpectedCondition<List<WebElement>> visibilityOfAllElements(final List<WebElement> elements);

    public LoginPage(WebDriver webDriver) {
        this.wait = new WebDriverWait(webDriver, 40L);
        this.webDriver = webDriver;
    }

    public void waitForLoginPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginForm)));
    }

    public void fillLogin(String username) {
        try {
            this.webDriver.findElement(By.cssSelector(emailField)).sendKeys(new CharSequence[]{username});
        } catch (Exception var3) {
            System.out.println(var3);
            throw new RuntimeException(passwordField);
        }
    }

    public void fillPassword(String password) {
        try {
            this.webDriver.findElement(By.cssSelector(passwordField)).sendKeys(new CharSequence[]{password});
        } catch (Exception var3) {
            throw new RuntimeException("Impossible to fill password", var3);
        }
    }


    public void clickLoginButton() {
        try {
            this.webDriver.findElement(By.cssSelector("button#SubmitLogin")).click();
        } catch (Exception var2) {
            throw new RuntimeException("Impossible to click button", var2);
        }
    }
}
