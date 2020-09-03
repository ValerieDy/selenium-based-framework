package com.company.Infrastructure.webdrivermanager.factory;

import com.company.Infrastructure.config.ConfigurationManager;
import com.company.Infrastructure.webdrivermanager.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CloudWebDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create () {
        BrowserType browserType = BrowserType.valueOf(ConfigurationManager.getInstance().getBrowser().toUpperCase());

        switch (browserType) {
                case CHROME:
                    return new ChromeDriver();
                case FIREFOX:
                    return new FirefoxDriver();
                case IE:
                    return new InternetExplorerDriver();
                case SAFARI:
                    return new SafariDriver();
                default:
                    throw new IllegalArgumentException("Unknown Cloud Browser type");
            }
    }

}
