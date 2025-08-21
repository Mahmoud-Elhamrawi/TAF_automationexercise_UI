package Utils.UtilPackage;

import Drivers.DriverManager;
import Utils.AllureUtils.AllureClass;
import Utils.LogUtil.LogClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilClass {
    //take screenshot
    public static final String screenshotPath = "test-output/screenshots/";

    public static void takeScreenshot(String screenshotName) {
        try {
            File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File dist = new File(screenshotPath + screenshotName + getTimestamp() + ".png");
            FileUtils.copyFile(src, dist);
            AllureClass.addScreenshotToAllure(screenshotName, dist.getPath());

            LogClass.info("Screenshot taken successfully");
        } catch (Exception e) {
            LogClass.error("Exception occured while taking screenshot " + e.getMessage());
        }


    }


    //scroll to element
    public static void scrollToElement(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }


    //get timestamp
    public static String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }


}
