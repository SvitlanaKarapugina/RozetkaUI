package pageObject.sections;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPopup {
    SelenideElement loginPopup = $(By.xpath("//div[contains(@class,'modal__holder')]"));

    public void verifyLoginPopupIsOpened() {
        loginPopup.shouldBe(Condition.appear);
    }
}
