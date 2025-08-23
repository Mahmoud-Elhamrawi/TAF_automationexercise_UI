package TestCases;


import Pages.P01_LandingPage;
import Pages.P05_HomePage;
import TestNGListener.TestNGListen;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import static Utils.DataUtil.ReadJsonFiles.getJsonKey;
import static Utils.DataUtil.ReadPropertiesFiles.getProperty;

@Listeners(TestNGListen.class)
public class TC01_RegisterTC extends TestBase {

    @Description("validate user can successfully sign up with valid data")
    @Test(priority = 1)
    public void registerTC() {

        new P01_LandingPage(driver)
                .validateLandingPage(getProperty("LandingPageTitle"), getProperty("landingPage"))
                .validateHomePage(getProperty("HomeItem"))
                .clickOnSignInButton(getProperty("loginItem"))
                .validateHeaderOfSighUpForm(getProperty("headerFormTitle"))
                .enterName(getJsonKey("NewUsers.name"))
                .enterEmail(getJsonKey("NewUsers.email") + "@gmail.com")
                .clickOnSignUpButton()
                .validateFormHeader("ENTER ACCOUNT INFORMATION")
                .selectTitle()
                .enterPassword(getJsonKey("NewUsers.password"))
                .selectDays(getJsonKey("NewUsers.day"))
                .selectMonth(getJsonKey("NewUsers.month"))
                .selectYear(getJsonKey("NewUsers.year"))
                .checkNewsletter()
                .checkOffer()
                .enterFirstName(getJsonKey("NewUsers.firstName"))
                .enterLastName(getJsonKey("NewUsers.lastName"))
                .enterAddress(getJsonKey("NewUsers.address"))
                .selectCountry(getJsonKey("NewUsers.country"))
                .enterState(getJsonKey("NewUsers.state"))
                .enterCity(getJsonKey("NewUsers.city"))
                .enterZipCode(getJsonKey("NewUsers.zip"))
                .enterMobileNumber(getJsonKey("NewUsers.phone"))
                .clickOnSubmitButton()
                .validateAccountCreatedText("Account Created!")
                .clickOnContinueButton()
                .validateHomePage("Logged in as mahTest");


    }


    @Description("validate user can delete account")
    @Test(priority = 2, dependsOnMethods = "registerTC")
    public void deleteAccount() {
        new P05_HomePage(driver)
                .deleteItem("5")
                .validateDeletedText("Account Deleted!.")
                .clickOnContinueButton();

    }

}
