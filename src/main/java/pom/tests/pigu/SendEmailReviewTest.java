package pom.tests.pigu;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.Common;
import pom.pages.Locator;
import pom.pages.pigu.MainPage;
import pom.tests.TestBase;
import pom.utilities.Constants;

import java.util.Random;

public class SendEmailReviewTest extends TestBase  {
    private MainPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        page = new MainPage();
    }

    @Test
    public void sendEmailReviewTest() {
        page.open();

        page.openInfoPanel();

        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.informationLinkSelector, Constants.waitSeconds)
                .click();

        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.contactByEmailSelector, Constants.waitSeconds)
                .click();

        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.reviewTopicSelector, Constants.waitSeconds)
                .click();

        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.reviewMessageSelector, Constants.waitSeconds)
                .sendKeys("Labai gera platforma!");

        Common.getElementWhenAvailable(Locator.Pigu.EmailReviewForm.reviewEmailSelector, Constants.waitSeconds)
                .sendKeys("rokas" + new Random().nextInt(1000, 9999) + "@gmail.com");

        Common.getElementWhenAvailable(
                Locator.Pigu.EmailReviewForm.reviewSubmitButtonSelector,
                Constants.waitSeconds).click();

        var successMessageElement = Common.getElementWhenAvailable(
                Locator.Pigu.EmailReviewForm.successMsgSelector,
                Constants.waitSeconds);

        String expectedSuccessMessage = "Dėkojame! Jūsų užklausa išsiųsta.";
        String actualSuccessText = successMessageElement.getText().trim();
        Assert.assertEquals(expectedSuccessMessage, actualSuccessText);
    }
}
