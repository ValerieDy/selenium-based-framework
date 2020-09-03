package com.company.Infrastructure.webdrivermanager;

import com.company.Infrastructure.config.ConfigurationManager;
import com.company.Infrastructure.webdrivermanager.enums.BrowserType;
import com.company.Infrastructure.webdrivermanager.enums.RunOn;
import com.company.Infrastructure.webdrivermanager.factory.CloudWebDriverFactory;
import com.company.Infrastructure.webdrivermanager.factory.LocalWebDriverFactory;
import com.company.Infrastructure.webdrivermanager.factory.RemoteWebDriverFactory;
import com.company.Infrastructure.webdrivermanager.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    public WebDriver getBrowser(){

       RunOn runOn = RunOn.valueOf(ConfigurationManager.getInstance().getRunOn().toUpperCase());

       WebDriverFactory factory;

       switch (runOn){
           case LOCAL:
               factory = new LocalWebDriverFactory();
               break;
           case REMOTE:
               factory = new RemoteWebDriverFactory();
               break;
           case CLOUD:
               factory = new CloudWebDriverFactory();
               break;
           default:
               throw new IllegalArgumentException("Unknown Web Driver Factory type");
       }

       return factory.create();

    }

    public void destroyBrowser(WebDriver browser){
        if(browser != null)
            browser.quit();
        System.out.println("Browser is closed");
    }

}
