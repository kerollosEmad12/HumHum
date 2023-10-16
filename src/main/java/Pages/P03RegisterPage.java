package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utility.Utilities.scrollToAndClick;
public class P03RegisterPage {
    WebDriver driver;

    private WebDriverWait wait;

    private static final int TIMEOUT = 30;

    public P03RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private final By create = By.cssSelector("a[href=\"/user-register\"]");
    public P03RegisterPage createBtn()
    {
        scrollToAndClick(driver, create);
        return this;
    }

    private final By selectTitle = By.cssSelector("div[class=\"col-lg-2\"] select[class=\"custom-select\"]:nth-child(2)");
    public P03RegisterPage title (String SelectTitle)
    {
        try {
            WebElement dropDown = driver.findElement(selectTitle);

            wait.until(ExpectedConditions.visibilityOf(dropDown));
            wait.until(ExpectedConditions.elementToBeClickable(dropDown));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropDown);

            Select select1 = new Select(dropDown);
            select1.selectByValue(SelectTitle);
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value='" + SelectTitle + "'; arguments[0].dispatchEvent(new Event('change'));",
                    driver.findElement(selectTitle)
            );
        }
        return this;
    }

    private final By firstname = By.id("f-name");
    public P03RegisterPage EnterFirstName(String firstName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname));
        wait.until(ExpectedConditions.elementToBeClickable(firstname));
        driver.findElement(firstname).sendKeys(firstName);
        return this;
    }

    private final By lastname = By.id("l-name");
    public P03RegisterPage EnterLastName(String lName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname));
        driver.findElement(lastname).sendKeys(lName);
        return this;
    }

    private final By email = By.id("email");
    public P03RegisterPage EnterEmail(String mail)
    {
        driver.findElement(email).sendKeys(mail);
        return this;
    }

    private final By password = By.id("NewPassword");
    public P03RegisterPage EnterPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    private final By confirmPassword = By.id("confirmPassword");
    public P03RegisterPage EnterConfirmPassword(String confirmPass)
    {
        driver.findElement(confirmPassword).sendKeys(confirmPass);
        return this;
    }

    private final By codeCountry = By.cssSelector("select[class=\"custom-select\"]:nth-child(3)");
    public P03RegisterPage selectCode (String countryCode)
    {
        try {
            WebElement dropdown = driver.findElement(codeCountry);

            wait.until(ExpectedConditions.visibilityOf(dropdown));
            wait.until(ExpectedConditions.elementToBeClickable(dropdown));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);

            Select select = new Select(dropdown);
            select.selectByValue(countryCode);
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value='" + countryCode + "'; arguments[0].dispatchEvent(new Event('change'));",
                    driver.findElement(codeCountry)
            );
        }
        return this;
    }

    private final By phone = By.id("phone");
    public P03RegisterPage EnterPhone(String Num)
    {
        driver.findElement(phone).sendKeys(Num);
        return this;
    }

    private final By checkBox = By.cssSelector("div[class=\"py-3 custom-control custom-checkbox\"]>input[type=\"checkbox\"]+label");
    public P03RegisterPage ClickCheckBox()
    {
        scrollToAndClick(driver, checkBox);
        return this;
    }

    private final By submit = By.cssSelector("div>button[type=\"submit\"]");
    public P03RegisterPage submitBtn()
    {
        scrollToAndClick(driver, submit);
        return this;
    }
}
