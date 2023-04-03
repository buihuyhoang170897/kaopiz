package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@type='text'and @name = 'email']")
    WebElement txtUsername;
    @FindBy(xpath = "//input[@name='password']")
    WebElement txtPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSignIn;

    @FindBy(xpath = "//div[@class='icheckbox_square-grey']")
    WebElement checkBoxRememberMe;

    @FindBy(xpath = "//span[normalize-space()='Email']")
    WebElement placeHolderUsername;

    @FindBy(xpath = "//span[normalize-space()='Password']")
    WebElement placeHolderPassword;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void logIn(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSignIn.click();
    }
    public void verifyPlaceHolder(){
        Assert.assertEquals(placeHolderUsername.getText(),"Email");
        Assert.assertEquals(placeHolderPassword.getText(),"Password");
    }

    public void checkRememberMeCheckBox(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxRememberMe));
        checkBoxRememberMe.click();
    }

}
