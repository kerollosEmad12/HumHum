import Drivers.DriverFactory;
import Pages.P01HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static Drivers.DriverHolder.setDriver;
public class C01TestBase {
    WebDriver driver;
    protected P01HomePage home;
    @Parameters("browser")
    @BeforeMethod()
    public WebDriver setupBrowser (@Optional("firefox") String browser)
    {
        if (driver == null) {
            driver = DriverFactory.getNewInstance(browser);
            setDriver(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            driver.get("https://st.humhum.work/");
            home = new P01HomePage(driver);
        }
        return driver;
    }

    @AfterMethod()
    public void quit() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(Duration.ofSeconds(5));
            driver.quit();
            driver = null;
        }
    }
}
