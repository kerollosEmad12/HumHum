package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utility.Utilities.scrollToAndClick;
public class P04LoginPage {
    WebDriver driver;

    private WebDriverWait wait;

    private static final int TIMEOUT = 50;

    public P04LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private final By Email = By.cssSelector("input[type=\"email\"]");
    public P04LoginPage EnterEmail(String email)
    {
        driver.findElement(Email).sendKeys(email);
        return this;
    }

    private final By password = By.cssSelector("input[type=\"password\"]");
    public P04LoginPage EnterPass(String pass)
    {
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    private final By submit = By.cssSelector("button[type=\"submit\"]");
    public P04LoginPage submitBtn()
    {
        scrollToAndClick(driver, submit);
        return this;
    }
}
