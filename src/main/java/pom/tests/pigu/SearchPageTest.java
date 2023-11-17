package pom.tests.pigu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.Common;
import pom.pages.Locator;
import pom.pages.pigu.MainPage;
import pom.pages.pigu.SearchPage;
import pom.tests.TestBase;
import pom.utilities.Constants;

public class SearchPageTest extends TestBase {
    private  MainPage mainPage;
    private  SearchPage searchPage;

    @BeforeMethod
    @Override
    public void setUp() {
        mainPage = new MainPage();
        searchPage = new SearchPage();
    }

    @Test
    public  void searchTest() {
        mainPage.open();
        searchPage.driver = mainPage.driver;

        WebElement firstProduct = mainPage.getFirstProduct();

        if (firstProduct == null)
        {
            Assert.fail("Failed to find any product in main page");
        }
        var name = firstProduct.getText();
        String searchName;
        if (name.length() < 20) {
            searchName = name;
        } else {
            searchName = name.substring(0, name.length() /  2);
        }

        searchPage.search(searchName);
        var searchResults = searchPage.getSearchResults();

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
