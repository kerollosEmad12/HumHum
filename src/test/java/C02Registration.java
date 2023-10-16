import Pages.P01HomePage;
import Pages.P02DataDrivenPage;
import Pages.P03RegisterPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class C02Registration extends C01TestBase {
    protected P03RegisterPage register;

    public static String globalEmail;

    SoftAssert soft = new SoftAssert();

    Faker faker = new Faker();

    @Test(priority = 1, dataProvider = "Invalid first name and last name", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidData(String firstName, String lastName)
    {
        home = new P01HomePage(driver);
        register = new P03RegisterPage(driver);

        home.closePopup();
        home.registerBtn();

        register.createBtn();
        String Title = "Mr";
        register.title(Title);
        register.EnterFirstName(firstName);
        register.EnterLastName(lastName);
        globalEmail = faker.internet().emailAddress();
        register.EnterEmail(globalEmail);
        register.EnterPassword("Test123!");
        register.EnterConfirmPassword("Test123!");
        String countryCode = "EG";
        register.selectCode(countryCode);
        String phoneNumber = faker.numerify("010########");
        register.EnterPhone(phoneNumber);
        register.ClickCheckBox();
        register.submitBtn();

        List<WebElement> errorElements = driver.findElements(By.cssSelector("div[class=\"col-lg-5\"]:nth-child(2) fieldset[class=\"form-group\"] div[class=\"error\"]"));

        if (!errorElements.isEmpty()) {
            String actualMsg = errorElements.get(0).getText();
            soft.assertTrue(actualMsg.contains("First name is mandatory"),
                    "actualMsg: " + actualMsg + " | expected Msg: " + "First name is mandatory");
        } else {
            System.out.println("The error message is not found");
        }
        soft.assertAll();

    }

    @Test (priority = 2, dataProvider = "Invalid Email", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidEmail (String Email)
    {
        home = new P01HomePage(driver);
        register = new P03RegisterPage(driver);

        home.closePopup();
        home.registerBtn();

        register.createBtn();
        String Title = "Mr";
        register.title(Title);
        register.EnterFirstName("Kerolos");
        register.EnterLastName("Emad");
        register.EnterEmail(Email);
        register.EnterPassword("Test123!");
        register.EnterConfirmPassword("Test123!");
        String countryCode = "EG";
        register.selectCode(countryCode);
        String phoneNumber = faker.numerify("010########");
        register.EnterPhone(phoneNumber);
        register.ClickCheckBox();
        register.submitBtn();

        List<WebElement> errorElements = driver.findElements(By.cssSelector("div[class=\"col-lg-12\"] fieldset[class=\"form-group\"] div[class=\"error\"]"));

        if (!errorElements.isEmpty()) {
            String actualMsg = errorElements.get(0).getText();
            soft.assertTrue(actualMsg.contains(" the email is found before. "),
                    "actualMsg: " + actualMsg + " | expected Msg: " + " the email is found before. ");
        } else {
            System.out.println("The error message is not found");
        }
        soft.assertAll();
    }

    @Test (priority = 3, dataProvider = "Invalid password and confirm password", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidPssAndConfirmPass (String pass, String confirmPass)
    {
        home = new P01HomePage(driver);
        register = new P03RegisterPage(driver);

        home.closePopup();
        home.registerBtn();

        register.createBtn();
        String Title = "Mr";
        register.title(Title);
        register.EnterFirstName("Kerolos");
        register.EnterLastName("Emad");
        globalEmail = faker.internet().emailAddress();
        register.EnterEmail(globalEmail);
        register.EnterPassword(pass);
        register.EnterConfirmPassword(confirmPass);
        String countryCode = "EG";
        register.selectCode(countryCode);
        String phoneNumber = faker.numerify("010########");
        register.EnterPhone(phoneNumber);
        register.ClickCheckBox();
        register.submitBtn();

        List<WebElement> errorElements = driver.findElements(By.cssSelector("div[class=\"col-lg-6\"]:nth-child(5) fieldset[class=\"form-group\"] div[class=\"error\"]:nth-child(5)"));

        if (!errorElements.isEmpty()) {
            String actualMsg = errorElements.get(0).getText();
            soft.assertTrue(actualMsg.contains("At least contains one char (Upper Case, Lower Case, Special Char, and Number)"),
                    "actualMsg: " + actualMsg + " | expected Msg: " + " At least contains one char (Upper Case, Lower Case, Special Char, and Number)");
        } else {
            System.out.println("The error message is not found");
        }
        soft.assertAll();
    }

    @Test (priority = 4, dataProvider = "Invalid phone number", dataProviderClass = P02DataDrivenPage.class)
    public void InvalidPhone (String number)
    {
        home = new P01HomePage(driver);
        register = new P03RegisterPage(driver);

        home.closePopup();
        home.registerBtn();

        register.createBtn();
        String Title = "Mr";
        register.title(Title);
        register.EnterFirstName("Kerolos");
        register.EnterLastName("Emad");
        globalEmail = faker.internet().emailAddress();
        register.EnterEmail(globalEmail);
        register.EnterPassword("Test123!");
        register.EnterConfirmPassword("Test123!");
        String countryCode = "EG";
        register.selectCode(countryCode);
        register.EnterPhone(number);
        register.ClickCheckBox();
        register.submitBtn();

        String actualMsg = driver.findElement(By.cssSelector("div[class=\"col-lg-9 col-8\"] fieldset[class=\"form-group\"] div[class=\"error\"]")).getText();

        switch (actualMsg){
            case " the mobile number is mandatory. ":
                soft.assertTrue(false, "actualMsg: "+actualMsg+" | "+ "expectedMsg: "+" the mobile number is mandatory. ");
                break;
            case "The mobile number field contains an invalid number.", "the phone number found before":
                break;
        }
        soft.assertAll();
    }
}
