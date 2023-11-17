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

        page.openCityOptions();

        var selectedCity = page.selectCityOption(2).toLowerCase().trim();

        page.confirmCitySelection();

        var actualName = page.getSelectedCityName();

        Assert.assertEquals(actualName, selectedCity);
    }
}
