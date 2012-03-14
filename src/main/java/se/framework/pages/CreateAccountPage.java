package se.framework.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.framework.utils.configProperties;

public class CreateAccountPage extends Page{

    public CreateAccountPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

        driver.get(System.getProperty("webdriver.base.url") + configProperties.getProperty("CreateAccount.Url"));


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

    @Override
    public void openAdmin() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    @FindBy(xpath = "//a/div[2]/div[2]")
    public WebElement emblemFacebook;




}
