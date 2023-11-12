package pigu;



import org.openqa.selenium.By;

public class MainPage extends BasePage {
    public void Open() {
        openChrome("https://pigu.lt/lt/");
        CloseCookieBanner();
    }

    public void CloseCookieBanner() {
        Common.clickOnElementWhenAvailableCustomised(MainPageLocators.Buttons.acceptCookieButton, 5);
    }

    public  void OpenLanguageOptions() {
        Common.clickOnElementWhenAvailableCustomised(MainPageLocators.Icons.cityChangeIconSelector, 5);
    }

    public  void SelectCityOption(int index) {
        Common.clickOnElementWhenAvailableCustomised(MainPageLocators.Options.cityOptionSelectorByIndex(index), 5);
    }

    public static class MainPageLocators {
        public static class Buttons {
            public static By acceptCookieButton =
                    By.xpath("//button[contains(@class, 'cookies_accept-all')]");

            public static By submit = By.xpath("//button[@type='submit']");
        }

        public static class Text {
            public static By cityNameSelector = By.xpath("//a[@class='c-link']/descendant::span");
        }

        public  static class Icons {
            public static By cityChangeIconSelector =
                    By.xpath("button[class='c-btn--primary h-btn--small']");
        }

        public static class Options {
            public static By cityOptionSelectorByIndex(int index)  {
                return By.xpath("//div[@class='button-box']//button[@value='" + index + ")']");
            }
        }
    }
}