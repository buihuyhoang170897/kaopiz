package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage{
    WebDriver driver;

    @FindBy(xpath = "//div[@class='text-uppercase font-monospace']")
    WebElement iconDashboard;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyDashboard(){
        Assert.assertEquals(iconDashboard.getText(),"DASHBOARD");
    }
}
