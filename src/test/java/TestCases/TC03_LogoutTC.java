package TestCases;


import Pages.P01_LandingPage;
import Pages.P05_HomePage;
import TestNGListener.TestNGListen;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Utils.DataUtil.ReadJsonFiles.getJsonKey;
import static Utils.DataUtil.ReadPropertiesFiles.getProperty;

@Listeners(TestNGListen.class)
public class TC03_LogoutTC extends TestBase {

    @Test
    public void logOutTC() {

        new P01_LandingPage(driver)
                .validateHomePage(getProperty("HomeItem"))
                .validateLandingPage(getProperty("LandingPageTitle"), getProperty("landingPage"))
                .clickOnSignInButton(getProperty("loginItem"))
                .validateHeaderOfLoginForm(getProperty("headerFormTitle2"))
                .enterEmailLogin(getJsonKey("NewUsers.email") + "@gmail.com")
                .enterPasswordLogin(getJsonKey("NewUsers.password"))
                .clickOnLoginButton();


        new P05_HomePage(driver)
                .validateHomePage("Logged in as mahTest")
                .clickOnLogOutButton();

        new P01_LandingPage(driver)
                .validateHomePage(getProperty("HomeItem"));

    }


}
