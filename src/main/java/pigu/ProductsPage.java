package pigu;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    public void setMinPriceFilterValue(String value) {
        var selector = By.xpath("//input[@class='price-from']");
        var minPriceInput = Common.getElementWhenAvailable(selector, 2);
        minPriceInput.click();
        minPriceInput.sendKeys(Keys.CONTROL + "a");
        minPriceInput.sendKeys(value);
        minPriceInput.sendKeys(Keys.ENTER);
    }

    public List<String> getFilterValues() {
        var selector = By.xpath("//span[@class='c-tag']");
        List<String> values = new ArrayList<>();

        var elements = Common.getElementsWhenAvailable(selector, 2);

        for (org.openqa.selenium.WebElement element : elements) {
            values.add(element.getText());
        }
        return values;
    }
}
