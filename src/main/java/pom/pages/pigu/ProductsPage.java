package pom.pages.pigu;

import org.openqa.selenium.Keys;
import pom.pages.Common;
import pom.pages.Locator;
import pom.utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    public void setMinPriceFilterValue(String value) {
        var minPriceInput = Common.getElementWhenAvailable(Locator.Pigu.ProductsPage.minPriceFilterSelector, Constants.waitSeconds);
        minPriceInput.click();
        minPriceInput.sendKeys(Keys.CONTROL + "a");
        minPriceInput.sendKeys(value);
        minPriceInput.sendKeys(Keys.ENTER);
    }

    public List<String> getFilterValues() {
        List<String> values = new ArrayList<>();
        var elements = Common.getElementsWhenAvailable(Locator.Pigu.ProductsPage.filterValuesSelector, Constants.waitSeconds);
        for (org.openqa.selenium.WebElement element : elements) {
            values.add(element.getText().trim());
        }
        return values;
    }
}
