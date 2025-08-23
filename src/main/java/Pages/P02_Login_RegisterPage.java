package Pages;

import Utils.ElementActions.ElementAction;
import Utils.LogUtil.LogClass;
import Utils.ValidationUtil.ValidationClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login_RegisterPage {
    private WebDriver driver;

    public P02_Login_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By formRegister_h2 = By.cssSelector("div[class=\"signup-form\"] h2");
    private final By name_inp = By.cssSelector("input[data-qa=\"signup-name\"]");
    private final By email_inp = By.cssSelector("input[data-qa=\"signup-email\"]");
    private final By signUp_btn = By.cssSelector("button[data-qa=\"signup-button\"]");


    private final By formLogin_h2 = By.cssSelector("div[class=\"login-form\"] h2");
    private final By eamilLogin_inp = By.cssSelector("input[data-qa=\"login-email\"]");
    private final By passwordLogin_inp = By.cssSelector("input[data-qa=\"login-password\"]");
    private final By login_btn = By.cssSelector("button[data-qa=\"login-button\"]");

private final By errorMessage_P = By.cssSelector("div[class=\"login-form\"] p");


    //methods actions
    @Step("enter name in register form")
    public P02_Login_RegisterPage enterName(String name) {
        ElementAction.type(driver, this.name_inp, name);
        LogClass.info("name entered : ", name);
        return this;
    }

    @Step("enter email in register form")
    public P02_Login_RegisterPage enterEmail(String email) {
        ElementAction.type(driver, this.email_inp, email);
        LogClass.info("email entered : ", email);
        return this;
    }

    @Step("click on sign up button in register form")
    public P03_RegisterPage clickOnSignUpButton() {
        ElementAction.click(driver, this.signUp_btn);
        LogClass.info("sign up button clicked");
        return new P03_RegisterPage(driver);
    }


@Step("enter email in login form")
    public P02_Login_RegisterPage enterEmailLogin(String email) {
        ElementAction.type(driver, this.eamilLogin_inp, email);
        LogClass.info("email entered : ", email);
        return this;
    }

    @Step("enter password in login form")
    public P02_Login_RegisterPage enterPasswordLogin(String password) {
        ElementAction.type(driver, this.passwordLogin_inp, password);
        LogClass.info("password entered : ", password);
        return this;
    }

    @Step("click on login button in login form")
    public P04_AccountConfirmedPage clickOnLoginButton() {
        ElementAction.click(driver, this.login_btn);
        LogClass.info("login button clicked");
        return new P04_AccountConfirmedPage(driver);
    }



    //Validations
    public P02_Login_RegisterPage validateHeaderOfSighUpForm(String expectedText) {
        ValidationClass.assertText(ElementAction.getText(driver, formRegister_h2), expectedText, "header of sign up form");
        LogClass.info("header of sign up form validated : ", expectedText);
        return this;
    }

    public P02_Login_RegisterPage validateHeaderOfLoginForm(String expectedText) {
        ValidationClass.assertText(ElementAction.getText(driver, formLogin_h2), expectedText, "header of login form");
        LogClass.info("header of login form validated : ", expectedText);
        return this;
    }

    public P02_Login_RegisterPage validateErrorMessage(String expectedText) {
        ValidationClass.assertText(ElementAction.getText(driver, errorMessage_P), expectedText, "error message");
        LogClass.info("error message validated : ", expectedText);
        return this;
    }


}
