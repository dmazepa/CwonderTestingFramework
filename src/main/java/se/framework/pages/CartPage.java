package se.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        //driver.get(configProperties.getProperty("HomePage.url") + "/checkout/cart/");
        driver.get(System.getProperty("webdriver.base.url") + "/checkout/cart/");
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    @FindBy(xpath = "//h2/a")
    public WebElement ProductName;

    @FindBy(css = "ul.item-options > li")
    public WebElement Size;

    @FindBy(xpath = "//td[4]/input")
    public WebElement Qty;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr/td[3]/span/span")
    public WebElement Price;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr/td[5]/span/span")
    public WebElement SubtotalTable;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr/td[4]/div/span")
    public WebElement PriceFromHome;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr/td[5]/div/span")
    public WebElement AmountFromHome;


    @FindBy(css = "td.a-right > span.price")
    public WebElement Subtotal;

    @FindBy(css = "strong > span.price")
    public WebElement Total;

    @FindBy(id = "page-title")
    public WebElement Title;

    @Override
    public CartPage clickAddToCart() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected SearchPage search() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void openAdmin() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @FindBy(linkText = "Remove")
    public WebElement Remove;

    @Override
    protected void openrandom() {
        // TODO Auto-generated method stub

    }
}
