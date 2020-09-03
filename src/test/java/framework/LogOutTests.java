package framework;

import com.company.Infrastructure.base.TestBase;
import com.company.Infrastructure.utils.SeleniumUtils;
import com.company.Infrastructure.utils.TimeUtils;
import com.company.framework.HomePage;
import com.company.framework.LoginPage;
import com.company.framework.partials.Footer;
import com.company.framework.partials.NavBar;
import org.junit.Assert;
import org.junit.Test;

public class LogOutTests extends TestBase {

    private SeleniumUtils seleniumUtils;
    private HomePage homePage;
    private TimeUtils timeUtils;
    private LoginPage loginPage;
    private NavBar navbar;

    private String email = "val.oceania@gmail.com";
    private String password = "test1234!";
    private String baseUrl = "http://automationpractice.com/index.php";
    private String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @Override
    protected void beforeTest() throws InterruptedException {

        browser.get(baseUrl);
        seleniumUtils = new SeleniumUtils(browser);
        logger.writeLog("Open Home page");
        homePage = new HomePage(browser);
        homePage.waitForHomePageLoad();
        navbar = new NavBar(browser);
        navbar.waitForNavBarLoad();

        logger.writeLog("Open LogIn Page");
        navbar.clickSignInLink();
        loginPage = new LoginPage(browser);
        loginPage.waitForLoginPageLoad();

        logger.writeLog("Fill email data");
        loginPage.fillLogin(email);

        logger.writeLog("Fill password data");
        loginPage.fillPassword(password);

        logger.writeLog("Click SignIn button");
        loginPage.clickLoginButton();
    }

    @Test
    public void LogOutViaNavBar()throws InterruptedException{

        NavBar navbar = new NavBar(this.browser);
        navbar.waitForNavBarLoad();

        logger.writeLog("Click Sign Out link");
        navbar.clickSignOutLink();

        logger.writeLog("Login page is open");
        loginPage = new LoginPage(browser);
        loginPage.waitForLoginPageLoad();

        Assert.assertEquals(browser.getCurrentUrl(), expectedUrl);
    }

    @Test
    public void LogOutViaFooter()throws InterruptedException{

        Footer footer = new Footer(this.browser);
        footer.waitForFooterLoad();

        logger.writeLog("Click Sign Out link");
        footer.clickSignOutLink();

        logger.writeLog("Login page is open");
        loginPage = new LoginPage(browser);
        loginPage.waitForLoginPageLoad();

        Assert.assertEquals(browser.getCurrentUrl(), expectedUrl);
    }

    @Test
    public void LogOutViaUrl()throws InterruptedException{

        String expectedUrl = baseUrl;

        logger.writeLog("Visit log out url");
        browser.get("http://automationpractice.com/index.php?mylogout=");

        logger.writeLog("Home page is open");
        homePage = new HomePage(browser);
        homePage.waitForHomePageLoad();

        Assert.assertEquals(browser.getCurrentUrl(), expectedUrl);
    }

}
