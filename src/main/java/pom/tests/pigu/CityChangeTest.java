package pom.tests.pigu;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.Common;
import pom.pages.Locator;
import pom.pages.pigu.MainPage;
import pom.tests.TestBase;

public class CityChangeTest extends TestBase {
    private MainPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        page = new MainPage();
    }

    @Test
    public void changeCity() {
        page.open();

        // 1 step - open city options
        page.openCityOptions();

        // 2 step - select second chip city from option list
        var selectedCity = page.selectCityOption(2).toLowerCase().trim();

        // 3 step - confirm selection
        Common.clickOnElement(Locator.Pigu.MainPage.Buttons.submit);

        // 4 step - get current selected city
        var actualName = Common.getTextFromElement(Locator.Pigu.MainPage.Text.cityNameSelector)
                .toLowerCase()
                .trim();

        // 5 step - assert selected city is actual selected city on main page
        Assert.assertEquals(actualName, selectedCity);
    }
}

