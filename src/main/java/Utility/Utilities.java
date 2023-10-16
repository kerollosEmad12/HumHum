package Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utilities {

    // To take screenshot
    public static void Screenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate=new Date();
        String screenshot = screenshotName + currntDate.toString().replace(" ","-").replace(":","-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "screenshots" + File.separator + screenshot + ".png"));
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToAndClick(WebDriver driver, By locator) {
        if (driver != null) {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            js.executeScript("arguments[0].click();", element);
        }
    }
}

