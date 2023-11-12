package pigu;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class MainPage extends BasePage {
    public void open() {
        openChrome("https://pigu.lt/lt/");
        closeCookieBanner();
    }

    public void closeCookieBanner() {
        Common.clickOnElementWhenAvailableCustomised(MainPageLocators.Buttons.acceptCookieButton, 5);
    }

    public  void openCityOptions() {
        Common.clickOnElementWhenAvailableCustomised(MainPageLocators.Icons.cityChangeIconSelector, 5);
    }

    public String selectCityOption(int index) {
        Common.waitElementWhenAvailableCustomised(MainPageLocators.Options.cityOptionSelectorByIndex(index), 5);
        var cityName = Common.getTextFromElement(MainPageLocators.Options.cityOptionSelectorByIndex(index));
        Common.clickOnElement(MainPageLocators.Options.cityOptionSelectorByIndex(index));
        return cityName;
    }

    public void openInfoPanel() {
        var infoIcon = Common.getElementWhenAvailable(MainPageLocators.Icons.infoIconSelector, 5);
        Actions action = new Actions(driver);
        action.moveToElement(infoIcon).perform();
    }

    public static class MainPageLocators {
        public static class Buttons {
            public static By acceptCookieButton =
                    By.xpath("//button[contains(@class, 'cookies_accept-all')]");

            public static By submit = By.xpath("//button[@type='submit']");
        }

        public static class Text {
            public static By cityNameSelector = By.xpath("//a[@class='c-link']/descendant::span");
        }

        public  static class Icons {
            public static By cityChangeIconSelector =
                    By.xpath("//i[contains(@class, 'c-icon--location')]");

            public static By infoIconSelector = By.xpath("//span[@class='h-td--none'][1]");
        }

        public static class Options {
            public static By cityOptionSelectorByIndex(int index)  {
                return By.xpath(  "//div[contains(@class, 'c-chip')]["+ index + "]");
            }
        }
    }
}