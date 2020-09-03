package com.company.Infrastructure.webdrivermanager.factory;

import com.company.Infrastructure.config.ConfigurationManager;
import com.company.Infrastructure.webdrivermanager.capabilities.BrowserCapabilities;
import com.company.Infrastructure.webdrivermanager.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LocalWebDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create() {

        BrowserType browserType = BrowserType.valueOf(ConfigurationManager.getInstance().getBrowser().toUpperCase());
        //BrowserCapabilities browserCapabilities = new BrowserCapabilities();
        try {
            switch (browserType) {
                case CHROME:
                    return new ChromeDriver(BrowserCapabilities.getChromeCapability());
                case FIREFOX:
                    return new FirefoxDriver(BrowserCapabilities.getFirefoxCapability());
                case IE:
                    return new InternetExplorerDriver(BrowserCapabilities.getIECapability());
                case SAFARI:
                    return new SafariDriver(BrowserCapabilities.getSafariCapability());
                default:
                    throw new IllegalArgumentException("Local Unknown browser type");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Local an error to initialize the browser");
        }

    }

}
