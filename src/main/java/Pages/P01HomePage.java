package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utility.Utilities.scrollToAndClick;

public class P01HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final int TIMEOUT = 30;


    public P01HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private final By popup = By.className("mfp-close");
    public P01HomePage closePopup ()
    {
        scrollToAndClick(driver, popup);
        return this;
    }

    private final By registerTap = By.cssSelector("div[class=\"login collapsed\"]");
    public P01HomePage registerBtn()
    {
        scrollToAndClick(driver, registerTap);
        return this;
    }
}
