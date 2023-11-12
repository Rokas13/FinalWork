package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pigu.Common;
import pigu.MainPage;
import pigu.ProductsPage;

public class FilterTest extends TestBase {
    private final MainPage page = new MainPage();
    private final ProductsPage productPage = new ProductsPage();

    @BeforeMethod
    @Override
    public void setUp() {

    }

    @Test
    public void filterTest() {
        page.open();

        var elements = Common.getElementWhenAvailable(By.xpath("//li[@class='h-mr--24']"), 1);
        elements.click();

        chooseCategory("14");
        chooseSubCategory("1");
        chooseSubCategory("1");

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

    public boolean isCategory()
    {
        var selector = By.xpath("(//div[@class='category-list-item-wrap all-categories-visible'])[1]");
        Common.waitElementWhenAvailableCustomised(selector, 2);
        return Common.isAvailable(selector);
    }

    public void chooseCategory(String number)
    {
        var CategorySectionSelector = By.xpath("(//h2[@class='h-h2--small h-fw--semibold h-mt--0'])["+number+"]");
        var CategorySection = Common.getElementWhenAvailable(CategorySectionSelector, 2);
        CategorySection.click();
    }

    public String chooseSubCategory(String number)
    {
        var subCategorySelector = By.xpath("(//div[@class='category-list-item-wrap all-categories-visible'])["+ number +"]");
        var subCategory = Common.getElementWhenAvailable(subCategorySelector, 2);
        var name = subCategory.getText().trim();
        subCategory.click();
        return name;
    }
}