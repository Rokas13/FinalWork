package pigu;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends MainPage {
    private By searchBoxSelector = By.cssSelector("input[id='searchInput']");

    public void open() {
        openChrome("https://pigu.lt/lt/");
        closeCookieBanner();
    }

    public void search(String text)
    {
        var searchElement = Common.getElementWhenAvailable(searchBoxSelector, 2);
        Actions action = new Actions(driver);
        action.moveToElement(searchElement).perform();

        searchElement.sendKeys(text);
        searchElement.sendKeys(Keys.RETURN);
    }

    public List<String> getSearchResults()
    {
        List<String> productNames = new ArrayList<>();

        var selector = By.cssSelector("p[class='product-name']");
        var items = Common.getElementsWhenAvailable(selector, 2);

        for (WebElement item : items)
        {
            productNames.add(item.getText());
        }

        return productNames;
    }
}
