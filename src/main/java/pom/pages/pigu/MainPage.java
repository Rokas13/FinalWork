package pom.pages.pigu;


import org.openqa.selenium.WebElement;
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

    public void confirmCitySelection() {
        Common.clickOnElement(Locator.Pigu.MainPage.Buttons.submit);
    }

    public String getSelectedCityName() {
        return Common.getTextFromElement(Locator.Pigu.MainPage.Text.cityNameSelector)
                .toLowerCase()
                .trim();
    }

    public void openAllItemsPanel() {
        Common.getElementWhenAvailable(
                Locator.Pigu.MainPage.Buttons.allItemsDropdownButtonSelector,
                Constants.waitSeconds).click();
    }

    public WebElement getFirstProduct() {
        var recommendedItemsHeader = Common.getElementsWhenAvailable(
                Locator.Pigu.SearchPage.recommendedItemsHeaderSelector,
                Constants.waitSeconds);

        Actions action = new Actions(driver);

        WebElement firstProduct = null;

        for (WebElement  section : recommendedItemsHeader)
        {
            action.scrollToElement(section).perform();

            var items = Common.getElementsWhenAvailable(
                    Locator.Pigu.SearchPage.itemsSelector,
                    Constants.waitSeconds);
            if (!items.isEmpty())
            {
                firstProduct = items.get(0);
                break;
            }
        }
        return firstProduct;
    }

    public String getSuccessDialogMessage() {
        var successMessageElement = Common.getElementWhenAvailable(
                Locator.Pigu.EmailReviewForm.successMsgSelector,
                Constants.waitSeconds);
        return successMessageElement.getText().trim();
    }

    public void submitReview() {
        Common.getElementWhenAvailable(
                Locator.Pigu.EmailReviewForm.reviewSubmitButtonSelector,
                Constants.waitSeconds).click();
    }

    public void inputReviewEmail(String email) {
        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.reviewEmailSelector, Constants.waitSeconds)
                .sendKeys(email);
    }

    public void inputReviewMessage(String message) {
        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.reviewMessageSelector, Constants.waitSeconds)
                .sendKeys( message);
    }

    public void selectReviewTopic() {
        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.reviewTopicSelector, Constants.waitSeconds)
                .click();
    }

    public void selectContactByEmailOption() {
        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.contactByEmailSelector, Constants.waitSeconds)
                .click();
    }

    public void clickInformationLink() {
        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.informationLinkSelector, Constants.waitSeconds)
                .click();
    }
}
