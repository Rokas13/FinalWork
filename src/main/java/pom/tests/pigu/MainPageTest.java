package pom.tests.pigu;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.pigu.CartItemPage;
import pom.pages.pigu.MainPage;
import pom.tests.TestBase;

import java.util.Random;

public class MainPageTest extends TestBase {
    private MainPage page;
    private CartItemPage cartPage;

    @BeforeMethod
    @Override
    public void setUp() {
        page = new MainPage();
        cartPage = new CartItemPage();
        page.open();
    }
    @Test
    public void changeCity() {


        page.openCityOptions();

        var selectedCity = page.selectCityOption(2).toLowerCase().trim();

        page.confirmCitySelection();

        var actualName = page.getSelectedCityName();

        Assert.assertEquals(actualName, selectedCity);
    }
    @Test
    public void sendEmailReviewTest() {

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
