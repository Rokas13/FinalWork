package pom.pages.pigu;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pom.pages.Common;
import pom.pages.Locator;
import pom.utilities.Constants;

import java.util.ArrayList;
import java.util.List;

import static pom.pages.Locator.Pigu.SearchPage.productNameSelector;

public class SearchPage extends MainPage {
    public void search(String text)
    {
        var searchElement = Common.getElementWhenAvailable(
                Locator.Pigu.SearchPage.searchBoxSelector,
                Constants.waitSeconds);
        Actions action = new Actions(driver);
        action.moveToElement(searchElement).perform();

        searchElement.sendKeys(text);
        searchElement.sendKeys(Keys.RETURN);
    }

    public List<String> getSearchResults()
    {
        List<String> productNames = new ArrayList<>();
        var items = Common.getElementsWhenAvailable(productNameSelector, Constants.waitSeconds);
        for (WebElement item : items)
        {
            productNames.add(item.getText().trim());
        }
        return productNames;
    }
}
