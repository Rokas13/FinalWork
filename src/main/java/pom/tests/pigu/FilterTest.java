package pom.tests.pigu;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.Common;
import pom.pages.Locator;
import pom.pages.pigu.MainPage;
import pom.pages.pigu.ProductsPage;
import pom.tests.TestBase;
import pom.utilities.Constants;

public class FilterTest extends TestBase {
    private MainPage page;
    private ProductsPage productPage;

    @BeforeMethod
    @Override
    public void setUp() {
        page = new MainPage();
        productPage = new ProductsPage();
    }

    @Test
    public void filterTest() {
        page.open();

        Common.getElementWhenAvailable(
                Locator.Pigu.MainPage.Buttons.allItemsDropdownButtonSelector,
                Constants.waitSeconds).click();

        page.chooseCategory("14");
        page.chooseSubCategory("1");
        page.chooseSubCategory("1");

        // wait for filer load
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var minPrice = "1";

        productPage.setMinPriceFilterValue(minPrice);

        var filterValues = productPage.getFilterValues();

        Assert.assertEquals(filterValues.size(), 1);
        Assert.assertTrue(filterValues.get(0).contains(minPrice));
    }
}