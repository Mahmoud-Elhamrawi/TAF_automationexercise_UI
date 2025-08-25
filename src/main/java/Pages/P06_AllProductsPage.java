package Pages;

import Utils.ElementActions.ElementAction;
import Utils.LogUtil.LogClass;
import Utils.ValidationUtil.ValidationClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_AllProductsPage {

    //Variables
    WebDriver driver;

    //Constructor
    public P06_AllProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By AllProducts_h2 = By.xpath("//h2[.='All Products']");
    private final By firstProductInList = By.cssSelector("a[href=\"/product_details/1\"]");

    //Methods actions
    @Step("click on product button")
    public P06_AllProductsPage clickOnProductButton() {
        ElementAction.click(driver, new P01_LandingPage(driver).getItemListInHeader("Products"));
        LogClass.info("product button clicked");
        return this;
    }

    @Step("select the first product")
    public P07_ProductDetails selectFirstProduct() {
        ElementAction.click(driver, firstProductInList);
        LogClass.info("first product selected");
        return new P07_ProductDetails(driver);
    }

    //verifications
    @Step("validate all products page open")
    public P06_AllProductsPage validateAllProductsPage(String expectedItem) {
        ValidationClass.assertTrueText(ElementAction.getText(driver, AllProducts_h2), expectedItem, "all products page open");
        return this;
    }



}
