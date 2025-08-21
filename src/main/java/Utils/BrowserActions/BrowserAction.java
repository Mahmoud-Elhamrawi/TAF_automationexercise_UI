package Utils.BrowserActions;

import Drivers.DriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserAction {
    //open browser
    public static void openBrowser(WebDriver driver, String url) {
        driver.get(url);
    }

    //close browser
    public static void closeBrowser(WebDriver driver) {
        driver.quit();
        DriverManager.removeDriver();
    }

    //get current url
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    //get title
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }


}
