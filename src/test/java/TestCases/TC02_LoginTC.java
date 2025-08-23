package TestCases;

import Pages.P01_LandingPage;
import Pages.P02_Login_RegisterPage;
import Pages.P05_HomePage;
import TestNGListener.TestNGListen;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Utils.DataUtil.ReadJsonFiles.getJsonKey;
import static Utils.DataUtil.ReadPropertiesFiles.getProperty;

@Listeners(TestNGListen.class)
public class TC02_LoginTC extends TestBase {


    @Description("Login User with correct email and password")
    @Test
    public void validateLoginTC() {
        new P01_LandingPage(driver)
                .validateHomePage(getProperty("HomeItem"))
                .validateLandingPage(getProperty("LandingPageTitle"), getProperty("landingPage"))
                .clickOnSignInButton(getProperty("loginItem"))
                .validateHeaderOfLoginForm(getProperty("headerFormTitle2"))
                .enterEmailLogin(getJsonKey("NewUsers.email") + "@gmail.com")
                .enterPasswordLogin(getJsonKey("NewUsers.password"))
                .clickOnLoginButton();

        new P05_HomePage(driver)
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



    @Description("Login User with incorrect email and password")
    @Test
    public void inValidateLoginTC() {
        new P01_LandingPage(driver)
                .validateHomePage(getProperty("HomeItem"))
                .validateLandingPage(getProperty("LandingPageTitle"), getProperty("landingPage"))
                .clickOnSignInButton(getProperty("loginItem"))
                .validateHeaderOfLoginForm(getProperty("headerFormTitle2"))
                .enterEmailLogin(getJsonKey("InvalidUsers.email") + "@gmail.com")
                .enterPasswordLogin(getJsonKey("InvalidUsers.password"))
                .clickOnLoginButton();

        new P02_Login_RegisterPage(driver)
                .validateErrorMessage("Your email or password is incorrect!");
    }






    }
