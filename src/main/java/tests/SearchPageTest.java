package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pigu.Common;
import pigu.MainPage;
import pigu.SearchPage;

public class SearchPageTest extends TestBase {

    private  final MainPage mainPage = new MainPage();
    private  final SearchPage searchPage = new SearchPage();

    @BeforeMethod
    @Override
    public void setUp() {

    }

    @Test
    public  void searchTest() {
        mainPage.open();

        var selector = By.cssSelector("p[class='product-name']");
        var selector2 = By.cssSelector("div[class='site-block']");
        var recommendedItemsHeader = Common.getElementsWhenAvailable(selector2, 2);
        Actions action = new Actions(mainPage.driver);

        WebElement firstProduct = null;

        for (WebElement  section : recommendedItemsHeader)
        {
            action.scrollToElement(section).perform();

            var items = Common.getElementsWhenAvailable(selector, 2);
            if (!items.isEmpty())
            {
                firstProduct = items.get(0);
                break;
            }
        }

        if (firstProduct == null)
        {
            Assert.fail("Failed to find any product in main page");
        }
        var name = firstProduct.getText();
        String searchName;
        if (name.length() < 20) {
            searchName = name;
        } else {
            searchName = name.substring(0, name.length() / 2);
        }

        searchPage.open();
        searchPage.search(searchName);

        var searchResults =
                searchPage.getSearchResults();

        for (String productName : searchResults)
        {
            if (productName.contains(searchName))
            {
                return;
            }
        }
        Assert.fail("Failed to find product in search page");
    }
}
