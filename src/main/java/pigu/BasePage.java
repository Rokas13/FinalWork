package pigu;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;

    public void openChrome(String url) {
        driver = Common.setUpChrome();
        Common.openUrl(url);
    }
}