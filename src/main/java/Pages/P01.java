package Pages;

import Utils.BrowserActions.BrowserAction;
import Utils.ElementActions.ElementAction;
import Utils.LogUtil.LogClass;
import Utils.ValidationUtil.ValidationClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01 {
    //Variables
    private WebDriver driver;

    //constructor
    public P01(WebDriver driver) {
        this.driver = driver;
    }

    //Locators


    public By getItemListInHeader(String item) {
        return By.xpath("//div[contains(@class,'shop-menu')]//ul/li/a[.=' " + item + "']");
    }


    //methods actions
    @Step("open landing page")
    public P01 openLandingPage(String url) {
        BrowserAction.openBrowser(driver, url);
        return this;
    }

    @Step("click on sign in button")
    public P02 clickOnSignInButton(String item) {
        ElementAction.click(driver, getItemListInHeader(item));
        LogClass.info("sign in button clicked : ", item);
        return new P02(driver);
    }


    //validations
    @Step("validate landing page")
    public P01 validateLandingPage(String expectedTitle, String expectedURL) {
        ValidationClass.assertTitle(BrowserAction.getTitle(driver), expectedTitle, "landing page title");
        ValidationClass.assertUrl(BrowserAction.getCurrentUrl(driver), expectedURL, "landing page url");
        LogClass.info("landing page title validated : ", expectedTitle);
        return this;
    }

    @Step("validate home page open ")
    public P01 validateHomePage(String expectedItem) {
        ValidationClass.assertText(ElementAction.getText(driver, getItemListInHeader(expectedItem)), expectedItem, "home page open");
        LogClass.info("home page open validated : ", expectedItem);
        return this;
    }
}
