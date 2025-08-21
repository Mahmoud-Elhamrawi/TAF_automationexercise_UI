package Drivers;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManager {
    public static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    //set Driver
    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    //get Driver
    public static WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            fail("Driver is null");
        }
        return threadLocalDriver.get();
    }

    //create Driver
    public static WebDriver createDriver(String browserName) {
       WebDriver driver = DriverFactory.getBrowser(browserName);
       setDriver(driver);
       return getDriver();
    }

    //remove Driver
    public static void removeDriver() {
        threadLocalDriver.remove();
    }


}
