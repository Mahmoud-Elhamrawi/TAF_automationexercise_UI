package TestCases;


import Drivers.DriverManager;
import Pages.P01;
import TestNGListener.TestNGListen;
import Utils.BrowserActions.BrowserAction;
import Utils.DataUtil.ReadJsonFiles;
import Utils.LogUtil.LogClass;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static Utils.DataUtil.ReadJsonFiles.getJsonKey;
import static Utils.DataUtil.ReadPropertiesFiles.getProperty;
import static Utils.UtilPackage.UtilClass.getTimestamp;

@Listeners(TestNGListen.class)
public class TC01 {
    WebDriver driver;
    ReadJsonFiles readJsonFiles;

    @Description("validate user can successfully sign up with valid data")
    @Test
    public void testTC() {

        new P01(driver)
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
                .validateHomePage("Logged in as mahTest")
                .deleteItem("5")
                .validateDeletedText("Account Deleted!.")
                .clickOnContinueButton();
    }

    //configuration
    @BeforeMethod
    public void setupTC() {
        //send browser
        driver = DriverManager.createDriver(getProperty("browserName"));
        LogClass.info("driver created on : " + getProperty("browserName"));

        //open driver
        new P01(driver)
                .openLandingPage(getProperty("landingPage"));
        LogClass.info("driver opened : " + getProperty("landingPage"));


    }

    @BeforeClass
    public void settingUpTC() {
        readJsonFiles = new ReadJsonFiles("jsondata");
        LogClass.info("json file loaded");
    }

    @AfterMethod
    public void tearDownTC() {
        BrowserAction.closeBrowser(driver);
    }


}
