package se.framework.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
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

    @FindBy(css = "h1")
    public WebElement textSearchResults;

    @FindBy(css = "p.note-msg")
    public WebElement areaSearchResults;

    @FindBy(css = "h5")
    public WebElement textMoreProducts;

    @FindBy(xpath = " //li/a/img")
    public WebElement imageProductMoreProducts;

    @FindBy(css = "h3.product-name > a")
    public WebElement nameProductMoreProducts;

    @FindBy(css = "a > span.price")
    public WebElement priceProductMoreProducts;

    @FindBy(css = "button.button.btn-cart")
    public WebElement buttonAddToCartProductMoreProducts;

    @FindBy(css = "strong")
    public WebElement Strong;

    @FindBy(css = "h2")
    public WebElement bottonSearch;

    @FindBy(css = "div.bottom-page-description > p")
    public WebElement bottonDescription;



}
