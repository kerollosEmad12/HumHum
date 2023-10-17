package Pages;
import Utility.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utility.Utilities.scrollToAndClick;
public class P05OrderPage {

    WebDriver driver;

    private WebDriverWait wait;

    private static final int TIMEOUT = 60;

    public P05OrderPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private final By Email = By.cssSelector("input[type=\"email\"]");
    public P05OrderPage EnterEmail(String email)
    {
        driver.findElement(Email).sendKeys(email);
        return this;
    }

    private final By password = By.cssSelector("input[type=\"password\"]");
    public P05OrderPage EnterPass(String pass)
    {
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    private final By submit = By.cssSelector("button[type=\"submit\"]");
    public P05OrderPage submitBtn()
    {
        scrollToAndClick(driver, submit);
        return this;
    }

    private final By GetY = By.xpath("//*[@class=\"tab-pane active\"]/div[2]//*/div[2]/div[2]/div[2]/a/button");
    public P05OrderPage GetYBtn()
    {
        scrollToAndClick(driver, GetY);
        return this;
    }

    private final By shop = By.cssSelector("button[class=\"btn dark event-btn continue-shopping\"]");
    public P05OrderPage shopBtn()
    {
        driver.findElement(shop).click();
        return this;
    }

    private final By Gift1 = By.cssSelector("div[class=\"product-silder specialOffers\"] div div div div div ul li:nth-child(2) a ");
    public P05OrderPage Gift1Btn()
    {
        Utilities.scrollToAndClick(driver, Gift1);
        return this;
    }

    private final By cart1 = By.xpath("//*[@class=\"tab-pane active\"]//div//a//button[@class=\"bg-main text-white\"]");
    public P05OrderPage cart1Btn()
    {
        driver.findElement(cart1).click();
        return this;
    }

    private final By basket = By.cssSelector("div[class=\"product-silder specialOffers\"] div div div div div ul li:nth-child(4) a ");
    public P05OrderPage basketBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(basket));
        WebElement hover = driver.findElement(basket);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Actions action = new Actions(driver);
        action.moveToElement(hover).click().perform();
        return this;
    }

    private final By cart2 = By.xpath("//*[@class=\"tab-pane active\"]//div//a//button[@class=\"bg-main text-white\"]");
    public P05OrderPage cart2Btn()
    {
        driver.findElement(cart2).click();
        return this;
    }

    private final By viewCart = By.cssSelector("button a[href=\"/cart\"]");
    public P05OrderPage viewCartBtn()
    {
        driver.findElement(viewCart).click();
        return this;
    }

    private final By coupon = By.cssSelector("input[class=\"my-2 h-100 p-3 w-100 itemInput\"]");
    public P05OrderPage addCoupon(String Coupon)
    {
        driver.findElement(coupon).sendKeys(Coupon);
        return this;
    }

    private final By apply = By.cssSelector("button[class=\"btn login-button my-2 py-3 px-4 w-auto btn-secondary\"]");
    public P05OrderPage applyBtn()
    {
        driver.findElement(apply).click();
        return this;
    }

    private final By cash = By.cssSelector("div[class=\"method cach\"] input[class=\"custom-control-input\"]+label");
    public P05OrderPage cashBtn()
    {
        scrollToAndClick(driver, cash);
        return this;
    }

    private final By accept = By.cssSelector("div[class=\"terms my-4 d-inline-block custom-input custom-control custom-checkbox\"] input[type=\"checkbox\"]+label");
    public P05OrderPage acceptBtn()
    {
        scrollToAndClick(driver, accept);
        return this;
    }

    private final By checkOut = By.cssSelector("div[class=\"checkout\"] button[type=\"submit\"]");
    public P05OrderPage checkOutBtn()
    {
        scrollToAndClick(driver, checkOut);
        return this;
    }

    private final By orderList = By.cssSelector("button[class=\"btn btn-outline-success mt-4\"]");
    public P05OrderPage orderListBtn()
    {
        scrollToAndClick(driver, orderList);
        return this;
    }
}
