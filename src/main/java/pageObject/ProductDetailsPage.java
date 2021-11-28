package pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ProductDetailsPage {
    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    By productTitle = By.cssSelector("h1.product__title");
    By productRating = By.cssSelector("div.product__rating");
    By itemTabs = By.xpath("//li[@class='tabs__item ng-star-inserted']");
    By productPrice = By.xpath("//p[contains(@class,'product-prices')]");


    public void verifyProductDetailsPageElementsIsPresent() {
        assertAll("person",
                () -> Assertions.assertTrue(driver.findElement(productTitle).isDisplayed(), "Product Title isn't present"),
                () -> Assertions.assertTrue(driver.findElement(productRating).isDisplayed(), "Product rating isn't present"),
                () -> Assertions.assertTrue(driver.findElement(itemTabs).isDisplayed(), "Product tabs isn't present"),
                () -> Assertions.assertTrue(driver.findElement(productPrice).isDisplayed(), "Product price isn't present")
        );
    }
}
