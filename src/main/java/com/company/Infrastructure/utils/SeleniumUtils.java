package com.company.Infrastructure.utils;

import org.openqa.selenium.WebDriver;


public class SeleniumUtils {

    private WebDriver driver;
    private String parentWindowHandle;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        parentWindowHandle = driver.getWindowHandle();
    }


    public void switchToWindow(String title){
        if (driver.getWindowHandles().size() < 2)
            return;
        for (String wnd: driver.getWindowHandles()){
            driver.switchTo().window(wnd);
            if (driver.getTitle().equals(title)) break;
        }
    }

    public void switchToParentWindow(){
        driver.switchTo().window(parentWindowHandle);
    }



}
