package pigu;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Common {
    public static void setUpChrome() {
        Driver.setChromeDriver();
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void quitDriver() {
        Driver.quitDriver();
    }

    private static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    private static List<WebElement> getElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    public static void sendKeysToElement(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static void clickOnElementWhenAvailableCustomised(By locator, int seconds) {

        for (int i = 0; i <= (seconds * 2); i++) {
            try {
                Thread.sleep(500);
                clickOnElement(locator);
                break;
            } catch (NoSuchElementException | InterruptedException e) {
                var a = "";
            }
        }
    }

    public static boolean waitElementWhenAvailableCustomised(By locator, int seconds) {

        for (int i = 0; i <= (seconds * 2); i++) {
            try {
                Thread.sleep(500);
                if (getElement(locator).isDisplayed()) {
                    return true;
                }
            } catch (NoSuchElementException | InterruptedException e) {

            }
        }

        return false;
    }

    public static void waitElementWhenVisible(By locator, int seconds) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    public static boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public static List<Boolean> getStatusesOfElements(By locator) {
        List<WebElement> elements = getElements(locator);
        List<Boolean> statuses = new ArrayList<>();

        for (WebElement element : elements) {
            statuses.add(element.isSelected());
        }

        return statuses;
    }

    public static String getElementAttributeValue(By locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }

    private static Select getSelect(By locator) {
        return new Select(getElement(locator));
    }

    public static void selectOptionByValue(By locator, String selectValue) {
        getSelect(locator).selectByValue(selectValue);
    }

    public static void selectOptionByIndex(By locator, int index) {
        getSelect(locator).selectByIndex(index);
    }

    private static Actions getActions(){
        return new Actions(Driver.getDriver());
    }

    public static void doubleClickWithActions(By locator) {
        getActions()
//                .moveToElement(getElement(locator))
                .doubleClick(getElement(locator))
                .perform();
    }

    public static void rightClickWithActions(By locator) {
        getActions()
                .moveToElement(getElement(locator))
                .contextClick()
                .perform();
    }

    public static void multipleSelectWithActions(By locator, String[] values) {

        // pasiimam visus listo irasus
        List<WebElement> elements = getSelect(locator).getOptions();

        Actions actions = getActions();
        actions.keyDown(Keys.CONTROL);

        // pilnas sarasas: "A","B","C","D"
        // musu sarasas: "B", "D"

        // 1as zingsnis
        // 1as Ciklas: "A"
        // 2as ciklas:
        //  1as zingsnis: "A" == "B"
        //  2as zingsnis: "A" == "D"

        // 2as zingsnis
        // 1as Ciklas: "B"
        // 2as ciklas:
        //  1as zingsnis: "B" == "B" => actions.click(element)
        //  2as zingsnis: "B" == "D"

        // 3as zingsnis
        // 1as Ciklas: "C"
        // 2as ciklas:
        //  1as zingsnis: "C" == "B"
        //  2as zingsnis: "C" == "D"

        // 4as zingsnis
        // 1as Ciklas: "D"
        // 2as ciklas:
        //  1as zingsnis: "D" == "B"
        //  2as zingsnis: "D" == "D" => actions.click(element)

        for (WebElement element : elements) { // 1as ciklas
            for (String value : values) {
                String currentValue = element.getAttribute("value");
                if (currentValue.equals(value)){
                    actions.click(element);
                }
            }
        }
        actions.perform();
    }

    public static void acceptAlert() {
        Driver.getDriver().switchTo().alert().accept();
    }

    public static String getTextFromAlertBox() {
        return Driver.getDriver().switchTo().alert().getText();
    }

    public static void sendKeysToAlert(String message) {
        Driver.getDriver().switchTo().alert().sendKeys(message);
    }
}