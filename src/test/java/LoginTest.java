import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testUserCanOpenMenu() {
        homePage.openMenu();
        menuSection.verifyMenuIsOpened();
        menuSection.clickOnLoginButton();
        loginPopup.verifyLoginPopupIsOpened();
    }
}
