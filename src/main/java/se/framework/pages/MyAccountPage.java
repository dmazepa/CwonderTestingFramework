package se.framework.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Page{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void open() {
        //To change body of implemented methods use File | Settings | File Templates.
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
    @FindBy(css = "li.success-msg > ul > li")
    public WebElement successMsg;

    @FindBy(css = "h2.sub-title")
    public WebElement welcomeMsg;

    @FindBy(css = "p.box-content")
    public WebElement contactInfomation;

    @FindBy(linkText = "remove")
    public WebElement removeJanrainID;
}
