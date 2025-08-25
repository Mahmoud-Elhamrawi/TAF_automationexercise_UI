package Pages;

import Utils.ElementActions.ElementAction;
import Utils.LogUtil.LogClass;
import Utils.ValidationUtil.ValidationClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_HomePage {
    private final WebDriver driver;

    public P05_HomePage(WebDriver driver) {
        this.driver = driver;
    }


    //locators
    public By itemsInHeader(String item) {
        return By.xpath("(//div[contains(@class,'shop-menu')]//ul/li/a)[" + item + "]");
    }


    //methods actions
    @Step("click on Delete button")
    public P04_AccountConfirmedPage deleteItem(String item) {
        ElementAction.click(driver, itemsInHeader(item));
        LogClass.info("delete button clicked");
        return new P04_AccountConfirmedPage(driver);
    }

    @Step("click on logout button")
    public P05_HomePage clickOnLogOutButton() {
        ElementAction.click(driver, itemsInHeader("4"));
        LogClass.info("logout button clicked");
        return this;
    }


    //verifications
    public P05_HomePage validateHomePage(String expectedItem) {
        ValidationClass.assertTrueText(ElementAction.getText(driver, itemsInHeader("10")), expectedItem, "home page open");
        return this;
    }


}
