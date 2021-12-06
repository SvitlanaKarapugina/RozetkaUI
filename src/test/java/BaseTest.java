import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import core.utils.CommonUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageObject.HomePage;
import pageObject.ProductDetailsPage;
import pageObject.ProductListPage;
import pageObject.sections.LoginPopup;
import pageObject.sections.MenuSection;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BaseTest {
    HomePage homePage;
    ProductListPage productListPage;
    ProductDetailsPage productDetailsPage;
    LoginPopup loginPopup;
    MenuSection menuSection;

    @BeforeEach
    public void setup() {
        Configuration.browser = CommonUtils.getCentralData("browser");
        Configuration.timeout = 6000;
        open("https://rozetka.com.ua/");
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
