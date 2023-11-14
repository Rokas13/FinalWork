package pom.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class Driver {
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();


    public static WebDriver setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.75");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        drivers.set(new ChromeDriver(options));
        drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        return drivers.get();
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void quitDriver() {
        drivers.get().close();
        drivers.get().quit();
        drivers.remove();
    }
}