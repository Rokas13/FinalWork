package pom.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
    }

    private void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

        String fileDirectory = "screenshots/";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HH_mm_ss_SSS");
        String date = LocalDateTime.now().format(formatter);

        String fileName = "_screenshot.png";
        File newFile = new File(fileDirectory + date + fileName);

        try {
            FileUtils.copyFile(screenshotFile, newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}