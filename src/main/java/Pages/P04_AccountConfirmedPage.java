package Pages;

import Utils.ElementActions.ElementAction;
import Utils.LogUtil.LogClass;
import Utils.ValidationUtil.ValidationClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_AccountConfirmedPage {
    private final WebDriver driver;

    public P04_AccountConfirmedPage(WebDriver driver) {
        this.driver = driver;
    }


    //locators
    private final By accountCreated_h2 = By.cssSelector("h2[data-qa=\"account-created\"] b");
    private final By continue_btn = By.cssSelector("a[data-qa=\"continue-button\"]");

    private final By Deleted_h2 = By.cssSelector("h2[data-qa=\"account-deleted\"] b");

    //methods actions
    public P05_HomePage clickOnContinueButton() {
        ElementAction.click(driver, continue_btn);
        LogClass.info("continue button clicked");
        return new P05_HomePage(driver);
    }

    //Validations
    public P04_AccountConfirmedPage validateAccountCreatedText(String expectedText) {
        ValidationClass.assertVisibility(driver.findElement(accountCreated_h2).isDisplayed(), "account created text is visible");
        LogClass.info("account created text is visible:", expectedText);
        return this;
    }


    public P04_AccountConfirmedPage validateDeletedText(String expectedText) {
        ValidationClass.assertVisibility(driver.findElement(Deleted_h2).isDisplayed(), "account deleted text is visible");
        LogClass.info("account deleted text is visible:", expectedText);
        return this;
    }

}
