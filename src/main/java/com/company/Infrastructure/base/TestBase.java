package com.company.Infrastructure.base;

import com.company.Infrastructure.logger.CmdTestLogger;
import com.company.Infrastructure.logger.FileTestLogger;
import com.company.Infrastructure.logger.TestLogger;
import com.company.Infrastructure.webdrivermanager.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class TestBase {

    private WebDriverManager wdm;
    protected WebDriver browser;
    protected TestLogger logger = getTestLogger();


    @Before
    public void setUp() throws InterruptedException {

        wdm = new WebDriverManager();
        browser = wdm.getBrowser();

        beforeTest();
    }

    @After
    public void tearDown(){
        afterTest();

        //if (logger.getClass().equals(FileTestLogger.class))
        //    ((FileTestLogger)logger).writeLog("tearDown");

        logger.writeLog("Close browser");
        wdm.destroyBrowser(browser);

    }

    protected void beforeTest() throws InterruptedException {}

    protected void afterTest(){}

    protected TestLogger getTestLogger(){return new CmdTestLogger();}



}
