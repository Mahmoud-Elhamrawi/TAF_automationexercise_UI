package Utils.ElementActions;

import Utils.WaitUtil.WaitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.UtilPackage.UtilClass.scrollToElement;

public class ElementAction {


    //click
    public static void click(WebDriver driver, By locator) {
        WaitClass.waitElementToBeClickable(driver, locator);
      //  scrollToElement(driver, locator);
        driver.findElement(locator).click();
    }


    //type
    public static void type(WebDriver driver, By locator, String text) {
        WaitClass.waitElementToBeClickable(driver, locator);
        driver.findElement(locator).sendKeys(text);
    }


    //getText
    public static String getText(WebDriver driver, By locator) {
        WaitClass.waitElementToBeVisible(driver, locator);
        //scrollToElement(driver, locator);
        return driver.findElement(locator).getText();
    }


    //getAttribute
    public static String getAttribute(WebDriver driver, By locator, String attribute) {
        WaitClass.waitElementToBeVisible(driver, locator);
        return driver.findElement(locator).getDomAttribute(attribute);
    }

}
