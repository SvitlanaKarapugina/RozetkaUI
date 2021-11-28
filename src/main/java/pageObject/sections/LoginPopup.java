package pageObject.sections;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPopup {
    WebDriver driver;

    public LoginPopup(WebDriver driver) {
        this.driver = driver;
    }

    By loginPopup = By.xpath("//div[contains(@class,'modal__holder')]");

    public void verifyLoginPopupIsOpened() {
        Assertions.assertTrue(driver.findElement(loginPopup).isDisplayed(), "Login popup is not opened");
    }
}
