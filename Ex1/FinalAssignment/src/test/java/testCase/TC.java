package testCase;

import DriverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TC {
    public static final String URL_WEBSITE_LOGIN = "https://phptravels.net/admin";
    public static final String URL_WEBSITE_LOGIN_EMAIL = "admin@phptravels.com";
    public static final String URL_WEBSITE_LOGIN_PASSWORD = "demoadmin";
    WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
        //start driver from DriverManager
        driver = DriverManager.getInstance().startDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void logIn() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.navigateToLoginPage(URL_WEBSITE_LOGIN);
        loginPage.checkRememberMeCheckBox();
        loginPage.verifyPlaceHolder();

        loginPage.logIn(URL_WEBSITE_LOGIN_EMAIL,URL_WEBSITE_LOGIN_PASSWORD);
        homePage.verifyDashboard();
    }

}
