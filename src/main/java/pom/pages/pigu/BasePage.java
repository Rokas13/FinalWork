package pom.pages.pigu;

import org.openqa.selenium.WebDriver;
import pom.pages.Common;

public class BasePage {
    public WebDriver driver;

    public void openChrome(String url) {
        driver = Common.setUpChrome();
        Common.openUrl(url);
    }
}