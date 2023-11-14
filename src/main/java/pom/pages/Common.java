package pom.pages;


import org.openqa.selenium.*;
import org.testng.Assert;
import pom.utilities.Driver;

import java.util.List;

public class Common {
    public static WebDriver setUpChrome() {
        return Driver.setChromeDriver();
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void quitDriver() {
        Driver.quitDriver();
    }

    public static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    public static List<WebElement> getElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    public  static boolean isAvailable(By locator) {
        try
        {
            getElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public  static  WebElement getElementWhenAvailable(By locator, int seconds) {
        if (!Common.waitElementWhenAvailableCustomised(locator, seconds)) {
            Assert.fail("Failed to find info selector");
        }

        return Common.getElement(locator);
    }

    public  static  List<WebElement> getElementsWhenAvailable(By locator, int seconds) {
        if (!Common.waitElementWhenAvailableCustomised(locator, seconds)) {
            Assert.fail("Failed to find info selector");
        }

        return getElements(locator);
    }

    public static void clickOnElementWhenAvailableCustomised(By locator, int seconds) {

        for (int i = 0; i <= (seconds * 2); i++) {
            try {
                Thread.sleep(500);
                clickOnElement(locator);
                break;
            } catch (NoSuchElementException | InterruptedException ignored) {
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
            } catch (NoSuchElementException | InterruptedException ignored) {

            }
        }

        return false;
    }
}
