package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pigu.Common;
import pigu.MainPage;
import tests.TestBase;

import java.util.Random;

public class SendEmailReviewTest extends TestBase {
    private final MainPage page = new MainPage();


    @BeforeMethod
    @Override
    public void setUp() {

    }

    @Test
    public void sendEmailReviewTest() {
        page.Open();

        page.openInfoPanel();

        Common.getElementWhenAvailable(By.xpath("//a[@widget-attachpoint='link']"), 5)
                .click();

        Common.getElementWhenAvailable(By.xpath("//div[@id='subject'][1]"), 5)
                .click();

        Common.getElementWhenAvailable( By.xpath("//li[@id='subjectpayments_info']"), 5)
                .click();

        Common.getElementWhenAvailable( By.xpath("//textarea[@name='message']"), 5)
                .sendKeys("Labai gera platforma!");

        Common.getElementWhenAvailable( By.xpath("//input[@name='email']"), 5)
                .sendKeys("rokas" + new Random().nextInt(1000, 9999) + "@gmail.com");

        Common.getElementWhenAvailable( By.xpath("//span[@role='button']"), 5)
                .click();

        var SuccessMessageSelector = By.xpath("//div[@class='system-message system-message-notice gray_bg mt20 mb0']/descendant::div");
        var successMessageElement = Common.getElementWhenAvailable( SuccessMessageSelector, 5);
        String expectedSuccessMessage = "Dėkojame! Jūsų užklausa išsiųsta.";
        String actualSuccessText = successMessageElement.getText().trim();
        Assert.assertEquals(expectedSuccessMessage, actualSuccessText);
    }
}