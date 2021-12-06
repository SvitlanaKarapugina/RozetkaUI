package pageObject.sections;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MenuSection {


    SelenideElement menuSection = $(By.xpath("//div[contains(@class,'side-menu drawer-content')]"));
    SelenideElement loginButton = $(By.xpath("//button[contains(@class,'side-menu__auth-button')][1]"));
    SelenideElement registrationsButton = $(By.xpath("//button[contains(@class,'side-menu__auth-button')][2]"));


    public void verifyMenuIsOpened() {
        menuSection.shouldBe(Condition.visible);
    }

    public void clickOnLoginButton() {
        loginButton.shouldBe(Condition.visible).click();
    }

    public void clickOnRegistrationButton() {
        registrationsButton.shouldBe(Condition.visible).click();
    }
}
