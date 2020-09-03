package com.company.Infrastructure.webdrivermanager.capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserCapabilities {

    public static ChromeOptions getChromeCapability() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, "85.0.4183.87");
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        return options;
    }

    public static SafariOptions getSafariCapability() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"Safari");
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, "12.0.2 (14606.3.4)");
        SafariOptions options = new SafariOptions();
        options.merge(capabilities);
        return options;
    }

    public static FirefoxOptions getFirefoxCapability() throws Exception{

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Firefox");
//        capabilities.setCapability(CapabilityType.BROWSER_VERSION, "64.0.2");
        FirefoxOptions options = new FirefoxOptions();
        options.merge(capabilities);
        return options;
    }

    public static InternetExplorerOptions getIECapability () throws Exception{

        DesiredCapabilities capabilities  = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, "123");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.merge(capabilities);
        return options;
    }
}
