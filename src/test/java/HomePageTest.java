import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void testUserCanOpenMenu() {
        homePage.openMenu();
        menuSection.verifyMenuIsOpened();
    }
}
