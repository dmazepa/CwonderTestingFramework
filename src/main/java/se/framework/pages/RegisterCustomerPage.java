package se.framework.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import se.framework.utils.configProperties;

import java.util.Set;

import static org.openqa.selenium.support.PageFactory.initElements;

public class RegisterCustomerPage extends Page {

    public RegisterCustomerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

        driver.get(System.getProperty("webdriver.base.url") + configProperties.getProperty("Register.Url"));


    }
    @Override
    public void openAdmin() {

        driver.get(System.getProperty("webdriver.base.url") + configProperties.getProperty("AdminCustomer.Url"));


    }

    @Override
    protected void openrandom() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CartPage clickAddToCart() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected SearchPage search() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @FindBy(xpath = "//div[2]/div[2]")
    public WebElement emblemFacebook;

    @FindBy(xpath = "//div[1]")
    public WebElement formSignInWith;

    @FindBy(id = "login")
    public WebElement fieldAdminPassword;

    @FindBy(id = "username")
    public WebElement fieldAdminLogin;

    @FindBy(xpath = "//div[3]/ul/li[4]/ul/li/a/span")
    public WebElement manageCustomers;

    @FindBy(xpath = "//input[@id='filter_email']")
    public WebElement filterImail;

    @FindBy(linkText = "Select All")
    public WebElement selectAll;

    @FindBy(id = "customerGrid_massaction-select")
    public WebElement selectAction;

    @FindBy(xpath = "//form[@id='customerGrid_massaction-form']/fieldset/span[4]/button")
    public WebElement buttonSubmitCustomer;

    @FindBy(xpath = "//button[2]")
    public WebElement buttonSearch;

    @FindBy(css = "input.form-button")
    public WebElement buttonSubmitAdmin;

    @FindBy(id = "email_address")
    public WebElement emailAddress;

    @FindBy(xpath = "//form[@id='form-validate']/div[2]/button")
    public WebElement buttonSubmit;

    @FindBy(xpath = "//ul[@id='nav']/li[4]/a/span")
    public WebElement menuCustomers;

    public MyAccountPage registerUser(String email, String password){
        String frameName;
        int frameind;
        frameind = driver.getPageSource().lastIndexOf("name=\"janrain_");
        frameName = driver.getPageSource().substring(frameind+6, frameind +27);
        driver.switchTo().frame(frameName).findElement(By.id("facebook")).click();
        Set<String> WindowHandles = driver.getWindowHandles();
        String[] HandlesToArray = (String[])WindowHandles.toArray(new String[WindowHandles.size()]);
        driver.switchTo().window(HandlesToArray[1]);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        driver.switchTo().window(HandlesToArray[0]);
        emailAddress.sendKeys("test3@speroteck.com");
        buttonSubmit.click();
        driver.switchTo().alert().accept();
        return PageFactory.initElements(driver, MyAccountPage.class);

    }
}
