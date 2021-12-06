import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import core.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.HomePage;
import pageObject.ProductDetailsPage;
import pageObject.ProductListPage;
import pageObject.sections.LoginPopup;
import pageObject.sections.MenuSection;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;
    ProductListPage productListPage;
    ProductDetailsPage productDetailsPage;
    LoginPopup loginPopup;
    MenuSection menuSection;

    @BeforeEach
    public void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(capabilities);
        setWebDriver(driver);
        initializeAllPages();
    }

    private void initializeAllPages() {
        homePage = new HomePage();
        productDetailsPage = new ProductDetailsPage();
        productListPage = new ProductListPage();
        loginPopup = new LoginPopup();
        menuSection = new MenuSection();
    }

    @AfterEach
    public void quite() {
        WebDriverRunner.clearBrowserCache();
        getWebDriver().quit();
    }
}
