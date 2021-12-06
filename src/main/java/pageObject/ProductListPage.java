package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductListPage {

    SelenideElement productListPageHeader = $(By.xpath("//h1[contains(@class,'catalog-heading ng-star-inserted')]"));
    List<SelenideElement> productsGrid = $$(By.xpath("//div[@data-goods-id]//a[contains(@class, 'goods-tile__picture')]"));
    SelenideElement emptySearchLabel = $(By.xpath("//*[@class ='catalog-empty__icon ng-star-inserted']"));

    public void verifyProductListPageHeader(String searchData) {
        productListPageHeader.shouldHave(Condition.text("«" + searchData + "»"));
    }

    public void clickOnFirstProduct() {
        productsGrid.get(1).shouldBe(Condition.visible).click();
    }

    public boolean isEmptySearchLabelPresent() {
        return emptySearchLabel.is(Condition.appear);
    }
}
