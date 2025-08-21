package Pages;

import Utils.ElementActions.ElementAction;
import Utils.LogUtil.LogClass;
import Utils.ValidationUtil.ValidationClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02 {
    private WebDriver driver;

    public P02(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By NewUser_h2 = By.cssSelector("div[class=\"signup-form\"] h2");
    private final By name_inp = By.cssSelector("input[data-qa=\"signup-name\"]");
    private final By email_inp = By.cssSelector("input[data-qa=\"signup-email\"]");
    private final By signUp_btn = By.cssSelector("button[data-qa=\"signup-button\"]");

    //methods actions
    @Step("enter name")
    public P02 enterName(String name) {
        ElementAction.type(driver, this.name_inp, name);
        LogClass.info("name entered : ", name);
        return this;
    }

    @Step("enter email")
    public P02 enterEmail(String email) {
        ElementAction.type(driver, this.email_inp, email);
        LogClass.info("email entered : ", email);
        return this;
    }

    @Step("click on sign up button")
    public P03 clickOnSignUpButton() {
        ElementAction.click(driver, this.signUp_btn);
        LogClass.info("sign up button clicked");
        return new P03(driver);
    }






    //Validations
    public P02 validateHeaderOfSighUpForm(String expectedText) {
        ValidationClass.assertText(ElementAction.getText(driver, NewUser_h2), expectedText, "header of sign up form");
        LogClass.info("header of sign up form validated : ", expectedText);
        return this;
    }

}
