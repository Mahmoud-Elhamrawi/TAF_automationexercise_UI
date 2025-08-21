package Drivers;

import Utils.LogUtil.LogClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class DriverFactory {

    public static WebDriver getBrowser(String browserName) {

        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--start-maximized");

                if(!System.getProperty("executionType").equals("local")) {
                    chromeOptions.addArguments("--headless");
                    LogClass.info("headless mode enabled");

                }


                Map<String, Object> chromePrefs = Map.of(
                        "profile.default_content_setting_values.notifications", 2,
                        "profile.password_manager_enabled", false,
                        "credentials_enable_service", false,
                        "auto_fill_enabled", false
                );
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                return new ChromeDriver(chromeOptions);

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-popup-blocking");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--disable-infobars");
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                edgeOptions.addArguments("--start-maximized");
                if(!System.getProperty("executionType").equals("local")) {
                    edgeOptions.addArguments("--headless");
                    LogClass.info("headless mode enabled");
                }
                Map<String, Object> edgePrefs = Map.of
                        ("profile.default_content_setting_values.notifications", 2,
                                "profile.password_manager_enabled", false,
                                "credentials_enable_service", false,
                                "auto_fill_enabled", false);
                edgeOptions.setExperimentalOption("prefs", edgePrefs);

                return new EdgeDriver(edgeOptions);
            case "firefox":
                return new FirefoxDriver();
            default:
                return null;

        }


    }


}
