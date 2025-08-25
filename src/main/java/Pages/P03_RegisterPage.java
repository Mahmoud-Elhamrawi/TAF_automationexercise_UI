package Pages;

import Utils.ElementActions.ElementAction;
import Utils.LogUtil.LogClass;
import Utils.ValidationUtil.ValidationClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class P03_RegisterPage {
    private final WebDriver driver;

    public P03_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By formHeader_h2 = By.xpath("//b[.='Enter Account Information']");
    private final By selectTitle = By.id("id_gender1");
    private final By password_inp = By.id("password");
    private final By selectOptionDays = By.id("days");
    private final By selectOptionMonth = By.id("months");
    private final By selectOptionYear = By.id("years");
    private final By checkNewsLetter = By.id("newsletter");
    private final By checkOffer = By.id("optin");
    private final By firstName_inp = By.id("first_name");
    private final By lastName_inp = By.id("last_name");
    private final By address_inp = By.id("address1");
    private final By country_SelectOption = By.id("country");
    private final By state_Inp = By.id("state");
    private final By city_Inp = By.id("city");
    private final By zipCode_Inp = By.id("zipcode");
    private final By mobileNumber_Inp = By.id("mobile_number");
    private final By submit_btn = By.cssSelector("button[data-qa=\"create-account\"]");

    //methods actions
    @Step("select title")
    public P03_RegisterPage selectTitle() {
        ElementAction.click(driver, selectTitle);
        LogClass.info("title selected");
        return this;
    }

    @Step("enter password")
    public P03_RegisterPage enterPassword(String password) {
        ElementAction.type(driver, password_inp, password);
        LogClass.info("password entered : ", password);
        return this;
    }

    @Step("select days")
    public P03_RegisterPage selectDays(String days) {
        new Select(driver.findElement(selectOptionDays)).selectByValue("1");
        LogClass.info("days selected : ", days);
        return this;
    }

    @Step("select month")
    public P03_RegisterPage selectMonth(String month) {
        new Select(driver.findElement(selectOptionMonth)).selectByValue("1");
        LogClass.info("month selected : ", month);
        return this;
    }

    @Step("select year")
    public P03_RegisterPage selectYear(String year) {
        new Select(driver.findElement(selectOptionYear)).selectByValue("2000");
        LogClass.info("year selected : ", year);
        return this;
    }

    @Step("check newsletter")
    public P03_RegisterPage checkNewsletter() {
        ElementAction.click(driver, checkNewsLetter);
        LogClass.info("newsletter checked");
        return this;
    }

    @Step("check offer")
    public P03_RegisterPage checkOffer() {
        ElementAction.click(driver, checkOffer);
        LogClass.info("offer checked");
        return this;
    }

    @Step("enter first name")
    public P03_RegisterPage enterFirstName(String firstName) {
        ElementAction.type(driver, firstName_inp, firstName);
        LogClass.info("first name entered : ", firstName);
        return this;
    }

    @Step("enter last name")
    public P03_RegisterPage enterLastName(String lastName) {
        ElementAction.type(driver, lastName_inp, lastName);
        LogClass.info("last name entered : ", lastName);
        return this;
    }

    @Step("enter address")
    public P03_RegisterPage enterAddress(String address) {
        ElementAction.type(driver, address_inp, address);
        LogClass.info("address entered : ", address);
        return this;
    }

    @Step("select country")
    public P03_RegisterPage selectCountry(String country) {
        new Select(driver.findElement(country_SelectOption)).selectByValue(country);
        LogClass.info("country selected : ", country);
        return this;
    }

    @Step("enter state")
    public P03_RegisterPage enterState(String state) {
        ElementAction.type(driver, state_Inp, state);
        LogClass.info("state entered : ", state);
        return this;
    }

    @Step("enter city")
    public P03_RegisterPage enterCity(String city) {
        ElementAction.type(driver, city_Inp, city);
        LogClass.info("city entered : ", city);
        return this;
    }

    @Step("enter zip code")
    public P03_RegisterPage enterZipCode(String zipCode) {
        ElementAction.type(driver, zipCode_Inp, zipCode);
        LogClass.info("zip code entered : ", zipCode);
        return this;
    }

    @Step("enter mobile number")
    public P03_RegisterPage enterMobileNumber(String mobileNumber) {
        ElementAction.type(driver, mobileNumber_Inp, mobileNumber);
        LogClass.info("mobile number entered : ", mobileNumber);
        return this;
    }

    @Step("click on submit button")
    public P04_AccountConfirmedPage clickOnSubmitButton() {
        ElementAction.click(driver, submit_btn);
        LogClass.info("submit button clicked");
        return new P04_AccountConfirmedPage(driver);
    }

    //validations
    public P03_RegisterPage validateFormHeader(String expectedText) {
        ValidationClass.assertTrueText(ElementAction.getText(driver, formHeader_h2), expectedText, "form header");
        return this;
    }


}
