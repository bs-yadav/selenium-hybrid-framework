package base;

import org.openqa.selenium.WebDriver;
/**
 *
 */
public class DriverManager {
    /**
     * Purpose: This class is used for managing WebDriver instances (like ChromeDriver, FirefoxDriver, etc.)
     */
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private DriverManager() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quit() {
        if (DriverManager.getDriver() != null){
            DriverManager.getDriver().quit();
            driver.remove();
        }
    }

}



