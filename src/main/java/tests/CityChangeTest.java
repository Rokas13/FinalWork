package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pigu.Common;
import pigu.MainPage;

public class CityChangeTest extends TestBase {
    private final MainPage page = new MainPage();

    @BeforeMethod
    @Override
    public void setUp() {

    }

    @Test
    public void changeCity() {
        page.open();

        // 1 step - open city options
        page.openCityOptions();

        // 2 step - select second chip city from option list
        var selectedCity = page.selectCityOption(2).toLowerCase().trim();

        // 3 step - confirm selection
        Common.clickOnElement(MainPage.MainPageLocators.Buttons.submit);

        // 4 step - get current selected city
        var actualName = Common.getTextFromElement(MainPage.MainPageLocators.Text.cityNameSelector).toLowerCase().trim();

        // 5 step - assert selected city is actual selected city on main page
        Assert.assertEquals(actualName, selectedCity);
    }
}
