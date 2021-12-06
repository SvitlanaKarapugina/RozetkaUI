package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ProductDetailsPage {
    SelenideElement productTitle = $("h1.product__title");
    SelenideElement productRating = $("div.product__rating");
    SelenideElement itemTabs = $(By.xpath("//li[@class='tabs__item ng-star-inserted']"));
    SelenideElement productPrice = $(By.xpath("//p[contains(@class,'product-prices')]"));


    public void verifyProductDetailsPageElementsIsPresent() {
        assertAll("person",
                () -> Assertions.assertTrue(productTitle.is(Condition.visible), "Product Title isn't present"),
                () -> Assertions.assertTrue(productRating.is(Condition.visible), "Product rating isn't present"),
                () -> Assertions.assertTrue(itemTabs.is(Condition.visible), "Product tabs isn't present"),
                () -> Assertions.assertTrue(productPrice.is(Condition.visible), "Product price isn't present")
        );
    }
}
