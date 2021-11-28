package core.driver;

import core.enums.Browsers;
import core.utils.CommonUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            createWebDriver();
        }
        return driver;
    }

    /**
     * Intiliaze Selenium Web driver and capabilities
     */
    private void createWebDriver() {
        switch (Browsers.valueOf(CommonUtils.getCentralData("browser"))) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER); // Resolve timeout exception issue in selenium like: [SEVERE]: Timed out receiving message from renderer: 0.100
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(CommonUtils.getCentralData("implicitly_wait"))));
        driver.get("https://rozetka.com.ua/");
    }
}
