package TestCases;

import Drivers.DriverManager;
import Pages.P01_LandingPage;
import Utils.BrowserActions.BrowserAction;
import Utils.DataUtil.ReadJsonFiles;
import Utils.LogUtil.LogClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static Utils.DataUtil.ReadPropertiesFiles.getProperty;

public class TestBase {
    WebDriver driver;
    ReadJsonFiles readJsonFiles;

    //configuration
    @BeforeClass
    public void setupTC() {
        //send browser
        driver = DriverManager.createDriver(getProperty("browserName"));
        LogClass.info("driver created on : " + getProperty("browserName"));

        //open driver
        new P01_LandingPage(driver)
                .openLandingPage(getProperty("landingPage"));
        LogClass.info("driver opened : " + getProperty("landingPage"));


    }

    @BeforeSuite
    public void settingUpTC() {
        readJsonFiles = new ReadJsonFiles("jsondata");
        LogClass.info("json file loaded");
    }

    @AfterClass
    public void tearDownTC() {
        BrowserAction.closeBrowser(driver);
    }


}
