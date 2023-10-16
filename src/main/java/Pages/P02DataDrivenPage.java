package Pages;

import org.testng.annotations.DataProvider;

public class P02DataDrivenPage {

    @DataProvider (name = "Invalid first name and last name")
    public static Object [] [] Data ()
    {
        return new Object[][] {
                {"","Emad"},
                {"K","Emad"},
                {"Ke","Emad"},
                {"Kerolos",""},
                {"Kerolos","E"},
                {"Kerolos","Em"},
                {"Kerolos","Emad"}
        };
    }

    @DataProvider (name = "Invalid Email")
    public static Object [] [] InvalidData ()
    {
        return new Object[][] {
                {""},
                {"m.elzoghbi24gmail.com"},
                {"m.elzoghbi24@gmail"},
                {"@gmail.com"},
                {"m.elzoghbi24@@gmail.com"},
                {"m.elzoghbi24@-gmail.com"},
                {"m.elzoghbi24@ gmail.com"},
                {"m.elzoghbi24@gmail.com"},
        };
    }

    @DataProvider (name = "Invalid password and confirm password")
    public static Object [] [] InvalidPassAndConfirmPass ()
    {
        return new Object[][] {
                {"fa123", "Fabrica123!"},
                {"Fabrica", "Fabrica123!"},
                {"fabrica123!", "Fabrica123!"},
                {"FABRICA123!", "Fabrica123!"},
                {"Fabrica123", "Fabrica123!"},
                {"12345678", "Fabrica123!"},
                {"@#%*&^!@ ", "Fabrica123!"},
                {"Fabrica 123!", "Fabrica123!"},
                {"Fabrica123!", ""},
                {"Fabrica123!", "Fabrica124!"},
                {"Fabrica123!", "fabrica123!"},
                {"Fabrica123!", "Fabrica 123!"},
                {"Fabrica123!", "kerolos123!"}
        };
    }

    @DataProvider (name = "Invalid phone number")
    public static Object [] [] InvalidPhone ()
    {
        return new Object[][]
                {
                        {""},
                        {"0125489355"},
                        {"656587566882"},
                        {"0103358asd97"},
                        {"0103358477 5"},
                        {"01033584770"}
                };
    }

    @DataProvider (name = "Invalid Login")
    public static Object [] [] InvalidLogin ()
    {
        return new Object[][]
                {
                        {"", "Asd@12312"},
                        {"kerolos-gmail.com", "Asd@12312"},
                        {"kerolos @gmail.com", "Asd@12312"},
                        {"Kerolos@gmail.com", "Asd123@12"},
                        {"kerolos/@gmail.com", "Asd@12312"},
                        {"keroemad451@gmail.com", ""},
                        {"keroemad451@gmail.com", "126381"},
                        {"keroemad451@gmail.com", "Asd123 12"},
                        {"keroemad451@gmail.com", "Asd12312!"},
                        {"keroemad451@gmail.com", "Asd12312"},
                };
    }
}
