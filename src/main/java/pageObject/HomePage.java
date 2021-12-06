package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    SelenideElement pageHeader = $("div.header-layout");
    SelenideElement searchField = $(By.xpath("//input[contains(@class,'search-form__input')]"));
    SelenideElement searchButton = $(By.xpath("//button[contains(@class,'search-form__submit')]"));
    SelenideElement hamburgerMenuButton = $(By.xpath("//button[@class='header__button']"));

    public void searchData(String searchData) {
        searchField.sendKeys(searchData);
        searchButton.click();
    }

    public void openMenu() {
        hamburgerMenuButton.click();
    }
}
