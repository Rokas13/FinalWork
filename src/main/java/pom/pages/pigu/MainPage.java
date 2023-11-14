package pom.pages.pigu;


import org.openqa.selenium.interactions.Actions;
import pom.pages.Common;
import pom.pages.Locator;
import pom.utilities.Constants;


public class MainPage extends BasePage {
    public void open() {
        openChrome(Constants.piguUrl);
        closeCookieBanner();
    }

    public void closeCookieBanner() {
        Common.clickOnElementWhenAvailableCustomised(
                Locator.Pigu.MainPage.Buttons.acceptCookieButton,
                Constants.waitSeconds);
    }

    public  void openCityOptions() {
        Common.clickOnElementWhenAvailableCustomised(
                Locator.Pigu.MainPage.Icons.cityChangeIconSelector,
                Constants.waitSeconds);
    }

    public String selectCityOption(int index) {
        Common.waitElementWhenAvailableCustomised(
                Locator.Pigu.MainPage.Options.cityOptionSelectorByIndex(index),
                Constants.waitSeconds);
        var cityName = Common.getTextFromElement(Locator.Pigu.MainPage.Options.cityOptionSelectorByIndex(index));
        Common.clickOnElement(Locator.Pigu.MainPage.Options.cityOptionSelectorByIndex(index));
        return cityName;
    }

    public void openInfoPanel() {
        var infoIcon = Common.getElementWhenAvailable(
                Locator.Pigu.MainPage.Icons.infoIconSelector,
                Constants.waitSeconds);
        Actions action = new Actions(driver);
        action.moveToElement(infoIcon).perform();
    }

    public void chooseCategory(String number)
    {
        Common.getElementWhenAvailable(
                Locator.Pigu.MainPage.categorySectionSelector(number),
                Constants.waitSeconds).click();
    }

    public void chooseSubCategory(String number)
    {
        Common.getElementWhenAvailable(
                Locator.Pigu.MainPage.subCategorySelector(number),
                Constants.waitSeconds).click();
    }
}
