package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {

    private static DriverManager instance = null;
    ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static synchronized DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void setWebDriver(WebDriver driver) {

        webDriver.set(driver);
    }

    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    public synchronized WebDriver startDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        setWebDriver(driver);

        return driver;
    }


}
