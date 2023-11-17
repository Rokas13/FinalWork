package pom.tests.pigu;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.pigu.MainPage;
import pom.pages.pigu.SearchPage;
import pom.tests.TestBase;

public class SearchTest extends TestBase {
    private  MainPage mainPage;
    private  SearchPage searchPage;

    @BeforeMethod
    @Override
    public void setUp() {
        mainPage = new MainPage();
        searchPage = new SearchPage();
        mainPage.open();
    }

    @Test
    public  void searchTest() {

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
