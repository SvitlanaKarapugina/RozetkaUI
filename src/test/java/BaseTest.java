import core.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.ProductDetailsPage;
import pageObject.ProductListPage;
import pageObject.sections.LoginPopup;
import pageObject.sections.MenuSection;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;
    ProductListPage productListPage;
    ProductDetailsPage productDetailsPage;
    LoginPopup loginPopup;
    MenuSection menuSection;

    @BeforeEach
    public void setup() {
        driver = new DriverFactory().getDriver();
        initializeAllPages();
    }

    private void initializeAllPages() {
        homePage = new HomePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productListPage = new ProductListPage(driver);
        loginPopup = new LoginPopup(driver);
        menuSection = new MenuSection(driver);
    }

    @AfterEach
    public void quite() {
        driver.quit();
    }
}
