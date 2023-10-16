import Pages.P01HomePage;
import Pages.P02DataDrivenPage;
import Pages.P04LoginPage;

import org.testng.annotations.Test;


public class C03Login extends C01TestBase {
    protected P04LoginPage login;


    @Test (dataProvider = "Invalid Login", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidData (String Email, String Pass)
    {
        home = new P01HomePage(driver);

        login = new P04LoginPage(driver);

        home.closePopup();
        home.registerBtn();

        login.EnterEmail(Email);
        login.EnterPass(Pass);
        login.submitBtn();

    }
}
