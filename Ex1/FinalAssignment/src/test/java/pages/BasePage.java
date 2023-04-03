package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    private static final long WAIT_TIME_OUT = 10;
    WebDriver driver;

    public void waitForVisibilityElement(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementClicked(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForSpecificTime(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
