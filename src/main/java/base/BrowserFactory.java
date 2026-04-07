package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import utils.ConfigReader;

/**
 *
 */
public enum BrowserFactory {
    /**
     * Purpose: create browser-specific WebDriver instances (CHROME, FIREFOX, EDGE, SAFARI) & initialize a browser before running tests
     */
    CHROME {
        @Override
        public WebDriver createDriver() {
            //WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))==true){
                options.addArguments("--headless=new");
            }
            return new ChromeDriver(options);
        }
    },

    FIREFOX {
        @Override
        public WebDriver createDriver(){
            //WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))==true){
                options.addArguments("-headless");
            }
            return new FirefoxDriver(options);
        }
    },

    SAFARI {
        @Override
        public WebDriver createDriver(){
            //WebDriverManager.safaridriver().setup();

            if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))==true){
                throw new IllegalArgumentException("Safari not support Headless mode");
            }
            return new SafariDriver();
        }
    }
    ;

    public abstract WebDriver createDriver();
}
