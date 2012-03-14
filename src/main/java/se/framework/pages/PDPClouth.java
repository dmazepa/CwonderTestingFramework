package se.framework.pages;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import se.framework.utils.configProperties;

import se.framework.utils.configProperties;

public class PDPClouth extends Page {

    public PDPClouth(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openrandom() {
        Random random = new Random();
        int x = 1 + random.nextInt(5);
        System.out.println("Category -" + configProperties.getProperty("CLP.Url" + x));
        driver.get(System.getProperty("webdriver.base.url") + configProperties.getProperty("CLP.Url" + x));
        //driver.get(configProperties.getProperty("HomePage.url")+configProperties.getProperty("CLP.Url"+x));
        int count = driver.findElements(By.xpath("//div[3]/button")).size();
        System.out.println(count);
        int ul, li;
        if (count <= 4) {
            ul = 1;
            li = 1 + random.nextInt(count);
        } else {
            ul = 1 + random.nextInt(count / 4);
            li = 1 + random.nextInt(4);
        }
        driver.findElement(By.xpath("//ul[" + ul + "]/li[" + li + "]/a/img")).click();
    }

    @FindBy(xpath = "//a[contains(text(),'Add to Cart')]")
    public WebElement buttonAddToCartCount;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement buttonAddToCart;

    @FindBy(xpath = "//select")
    public WebElement SelectSize;

    @Override
    public CartPage clickAddToCart() {
        buttonAddToCart.click();
        return PageFactory.initElements(driver, CartPage.class);
    }

    @Override
    protected SearchPage search() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void openAdmin() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @FindBy(xpath = "//dl[@id='configurable-options-list']/dd/div/select")
    public WebElement Size;

    @FindBy(css = "div.product-release-date")
    public WebElement RaleaseDate;

    @FindBy(css = "h1")
    public WebElement ProductName;

    @FindBy(css = "a.button.btn-wishlist")
    public WebElement AddToWishlist;

    @FindBy(xpath = "//label")
    public WebElement QtyText;

    @FindBy(xpath = "//div/span/span")
    public WebElement Price;

    @FindBy(id = "qty")
    public WebElement Qty;

    @FindBy(id = "product-image")
    public WebElement ProductImage;

    @FindBy(css = "div.std > p")
    public WebElement Details;

    @FindBy(css = "div.std")
    public WebElement DetailsNotSize;

    @FindBy(css = "h4.track-header")
    public WebElement TrackListing;

    @FindBy(css = "td.track-number")
    public WebElement TrackNumber;

    @FindBy(css = "li.item.first")
    public WebElement YouAlsoFirst;

    @FindBy(css = "li.item.last")
    public WebElement YouAlsoLast;

    @FindBy(css = "div.block-title > strong")
    public WebElement YouAlsoText;

    @FindBy(css = "div.share.box")
    public WebElement ShareBox;

    @FindBy(css = "p.no-rating.box")
    public WebElement RatingBox;

    @FindBy(linkText = "Be the first to review this product")
    public WebElement BeFirst;

    @FindBy(xpath = "//table[@id='downloadable-links-list']/tbody/tr/td[3]/label")
    public WebElement TrackName;

    @FindBy(xpath = "//div[3]/p[2]")
    public WebElement TextTasks;

    @FindBy(xpath = "//p[3]")
    public WebElement AreaTasks;

    @FindBy(xpath = "//li/a/img")
    public WebElement MiniImage;

    @Override
    protected void open() {
        // TODO Auto-generated method stub

    }


}
