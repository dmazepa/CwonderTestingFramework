package se.framework.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.ie.InternetExplorerDriver;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


import org.testng.annotations.BeforeTest;
import se.framework.data.userData;
import se.framework.utils.configProperties;

import static java.lang.System.getProperty;
import static org.testng.Assert.*;


public class BasicTestCase {

    protected static WebDriver driver;

    public userData customer = new userData("test1@speroteck.com", "0934177255", "14021", "Ukraine");

    @BeforeTest
    protected WebDriver getWebDriver() {
        if (driver == null && getProperty("browser") != null) {
            if ("ChromeDriver".compareTo(System.getProperty("browser")) == 0) {
                driver = new ChromeDriver();
            } else if ("IexplorerDriver".compareTo(System.getProperty("browser")) == 0) {
                driver = new InternetExplorerDriver();
            } else {
                driver = new FirefoxDriver();
            }


        } else if (driver == null) {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(configProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
        return driver;
    }


    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
    }

}
