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

        page.clickInformationLink();

        page.selectContactByEmailOption();

        page.selectReviewTopic();

        page.inputReviewMessage("Labai gera platforma!");

        page.inputReviewEmail("rokas" + new Random().nextInt(1000, 9999) + "@gmail.com");

        page.submitReview();

        var actualSuccessText =  page.getSuccessDialogMessage();
        String expectedSuccessMessage = "Dėkojame! Jūsų užklausa išsiųsta.";
        Assert.assertEquals(expectedSuccessMessage, actualSuccessText);
    }


}
