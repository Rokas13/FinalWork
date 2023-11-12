package tests;



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
        // atidaryti MainPage
        page.Open();

        //Paspausti miesto keitimo icona
        page.OpenLanguageOptions();

        //Pakeisti miesta i Kaunas
        page.SelectCityOption(2);

        Common.clickOnElement(MainPage.MainPageLocators.Buttons.submit);

        Common.getTextFromElement(MainPage.MainPageLocators.Text.cityNameSelector);
    }
}