package pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage {
    WebDriver driver;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    By productListPageHeader = By.xpath("//h1[contains(@class,'catalog-heading ng-star-inserted')]");
    By productsGrid = By.xpath("//div[@data-goods-id]//a[contains(@class, 'goods-tile__picture')]");
    By emptySearchLabel = By.xpath("//*[@class ='catalog-empty__icon ng-star-inserted']");

    public void verifyProductListPageHeader(String searchData) {
        Assertions.assertEquals("«" + searchData + "»", driver.findElement(productListPageHeader).getText(), "Page Search data header incorrect");
    }

    public void clickOnFirstProduct() {
        driver.findElement(productsGrid).click();
    }

    public boolean isEmptySearchLabelPresent() {
        return driver.findElement(emptySearchLabel).isDisplayed();
    }
}
