import core.enums.Browsers;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

public class SearchTest extends BaseTest {
    private final String searchData = "Canon EOS 800D";
    private final String searchIncorrectData = "fsfdgdghsdsfd";

    @Test
    public void testSearchPositive() {
        homePage.searchData(searchData);
        productListPage.verifyProductListPageHeader(searchData);
        productListPage.clickOnFirstProduct();
        productDetailsPage.verifyProductDetailsPageElementsIsPresent();
    }

    @Disabled
    @Test
    public void testSearchIncorrectData() {
        homePage.searchData(searchIncorrectData);
        Assertions.assertTrue(productListPage.isEmptySearchLabelPresent(), "Empty search is not present");
    }
}
