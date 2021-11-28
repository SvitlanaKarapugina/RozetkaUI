package pageObject.sections;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuSection {
    WebDriver driver;

    public MenuSection(WebDriver driver) {
        this.driver = driver;
    }

    By menuSection = By.xpath("//div[contains(@class,'side-menu drawer-content')]");
    By loginButton = By.xpath("//button[contains(@class,'side-menu__auth-button')][1]");
    By registrationsButton = By.xpath("//button[contains(@class,'side-menu__auth-button')][2]");


    public void verifyMenuIsOpened() {
        Assertions.assertTrue(driver.findElement(menuSection).isDisplayed());
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickOnRegistrationButton() {
        driver.findElement(registrationsButton).click();
    }
}
