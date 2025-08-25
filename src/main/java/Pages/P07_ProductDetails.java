package Pages;

import Utils.ElementActions.ElementAction;
import Utils.LogUtil.LogClass;
import Utils.ValidationUtil.ValidationClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_ProductDetails {
    WebDriver driver;

    public P07_ProductDetails(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By priceOfItem = By.xpath("//span[text()='Rs. 500']");
    private final By nameOfItem = By.cssSelector(".product-information h2");
    private final By nameOfCategory = By.xpath("//p[contains(text(),'Category')]");

    private final By itemAvailabilityLabel = By.xpath("//p[contains(text(),' In Stock')]/b");
    private final By itemAvailability = By.xpath("//p[contains(text(),' In Stock')]");


    private final By itemConditionLabel = By.xpath("//p[contains(text(),' New')]/b");
    private final By itemCondition = By.xpath("//p[contains(text(),' New')]");


    private final By itemBrandLabel = By.xpath("//p[contains(text(),' Polo')]/b");
    private final By itemBrand = By.xpath("//p[contains(text(),' Polo')]");


    //verifications
    @Step("validate item details")
    public P07_ProductDetails validateItemDetails(String expectedPrice, String expectedName, String expectedCategory, String expectedAvailability, String expectedCondition, String expectedBrand) {
        ValidationClass.assertTrueText(ElementAction.getText(driver, priceOfItem), expectedPrice, "item price");
        LogClass.info("item price is " + ElementAction.getText(driver, priceOfItem));

        ValidationClass.assertEmptyValue(ElementAction.getText(driver, nameOfItem).isEmpty(), "item name not visible");
        LogClass.info("item name is " + ElementAction.getText(driver, nameOfItem));

        ValidationClass.assertTrueText(ElementAction.getText(driver, nameOfCategory).contains("Category:"), "category label not found");
        ValidationClass.assertTrueText(!(ElementAction.getText(driver, nameOfCategory)).split(":")[1].trim().isEmpty(), "category value is missing");
        LogClass.info("item category is " + ElementAction.getText(driver, nameOfCategory));

        ValidationClass.assertTrueText(ElementAction.getText(driver, itemAvailabilityLabel).contains("Availability:"), "category label not found");
        ValidationClass.assertTrueText(!(ElementAction.getText(driver, itemAvailability)).split(":")[1].trim().isEmpty(), "category value is missing");
        LogClass.info("item availability is " + ElementAction.getText(driver, itemAvailability));

        ValidationClass.assertTrueText(ElementAction.getText(driver, itemConditionLabel).contains("Condition:"), "category label not found");
        ValidationClass.assertTrueText(!(ElementAction.getText(driver, itemCondition)).split(":")[1].trim().isEmpty(), "category value is missing");
        LogClass.info("item condition is " + ElementAction.getText(driver, itemCondition));

        ValidationClass.assertTrueText(ElementAction.getText(driver, itemBrandLabel).contains("Brand:"), "category label not found");
        ValidationClass.assertTrueText(!(ElementAction.getText(driver, itemBrand)).split(":")[1].trim().isEmpty(), "category value is missing");
        LogClass.info("item brand is " + ElementAction.getText(driver, itemBrand));

        return new P07_ProductDetails(driver);
    }


}
