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
        page.open();
    }

    @Test
    public void filterTest() {
        var minPrice = "1";

        page.openAllItemsPanel();

        page.chooseCategory("14");
        page.chooseSubCategory("1");
        page.chooseSubCategory("1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        productPage.setMinPriceFilterValue(minPrice);

        var filterValues = productPage.getFilterValues();

        Assert.assertEquals(filterValues.size(), 1);
        Assert.assertTrue(filterValues.get(0).contains(minPrice));
    }


}