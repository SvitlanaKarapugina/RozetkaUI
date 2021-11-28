package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By pageHeader = By.cssSelector("div.header-layout");
    By searchField = By.xpath("//input[contains(@class,'search-form__input')]");
    By searchButton = By.xpath("//button[contains(@class,'search-form__submit')]");
    By hamburgerMenuButton = By.xpath("//button[@class='header__button']");

    public void searchData(String searchData) {
        driver.findElement(searchField).sendKeys(searchData);
        driver.findElement(searchButton).click();
    }

    public void openMenu() {
        driver.findElement(hamburgerMenuButton).click();
    }
}
