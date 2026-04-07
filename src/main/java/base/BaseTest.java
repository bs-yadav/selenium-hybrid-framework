package base;

import enums.EnvironmentType;
import org.testng.annotations.Parameters;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browserParam) {
        String browser = (browserParam != null && !browserParam.isEmpty()) ? browserParam : ConfigReader.getProperty("browser");
        String environment = ConfigReader.getProperty("environment");

        BrowserFactory browserFactory = BrowserFactory.valueOf(browser.toUpperCase());
        EnvironmentType environmentType = EnvironmentType.valueOf(environment.toUpperCase());

        driver = browserFactory.createDriver();
        DriverManager.setDriver(driver);
        driver.get(environmentType.getUrl());
    }

    @AfterClass
    public void tearDown(){
        DriverManager.quit();
    }

}
