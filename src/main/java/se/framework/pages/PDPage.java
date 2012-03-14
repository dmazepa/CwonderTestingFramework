package se.framework.pages;


import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import se.framework.utils.configProperties;



public class PDPage extends Page {

    public PDPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openrandom() throws InterruptedException {
        Random random = new Random();
        int x = 1 + random.nextInt(6);
        System.out.println("Category -" + configProperties.getProperty("CLP.Url" + x));
        driver.get(System.getProperty("webdriver.base.url") + configProperties.getProperty("CLP.Url" + x));
        int count = driver.findElements(By.xpath("//li/a[2]")).size();
        System.out.println(count);
        int ul, li;
        if (count <= 3) {
            ul = 1;
            li = 1 + random.nextInt(count);
        } else {
            ul = 1 + random.nextInt(count / 3);
            li = 1 + random.nextInt(3);
        }
        System.out.println(ul);
        System.out.println(li);

       /* Actions builder = new Actions(driver);
        builder.contextClick(driver.findElement(By.xpath("//ul[" + ul + "]/li[" + li + "]/a/img")));
        builder.moveToElement(driver.findElement(By.xpath("//ul[" + ul + "]/li[" + li + "]/a/img"))).click();*/
        /*JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 500);");*/

        driver.findElement(By.xpath("//ul[" + 1 + "]/li[" + 1 + "]/a/img")).click();

    }

    public void openmusic() {
        Random random = new Random();
        driver.get(System.getProperty("webdriver.base.url") + "/music-1.html");
        //driver.get(configProperties.getProperty("HomePage.url") + "/music-1.html");
        int count = driver.findElements(By.xpath("//div[3]/button")).size();
        System.out.println(count);
        int ul = 1 + random.nextInt(count / 4);
        int li = 1 + random.nextInt(4);
        /*if (ul ==1){
              li++;
          }*/
       // JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //jsExecutor.executeScript("window.scrollTo(0, 100);");
        driver.findElement(By.xpath("//ul[" + ul + "]/li[" + li + "]/h[2]/a")).click();
    }

    @FindBy(xpath = "//button[@type='button']")
    public WebElement buttonAddToCart;

    @FindBy(xpath = "//select")
    public WebElement selectorColor;

    @FindBy(xpath = "//dl[@id='configurable-options-list']/dd/div/select")
    public WebElement Size;

    @Override
    public CartPage clickAddToCart() throws InterruptedException {
        buttonAddToCart.click();
        Thread.sleep(8000);
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

    @FindBy(css = "label")
    public WebElement QtyText;

    @FindBy(css = "div.product-release-date")
    public WebElement RaleaseDate;

    @FindBy(css = "h1")
    public WebElement ProductName;

    @FindBy(css = "a.button.btn-wishlist")
    public WebElement AddToWishlist;

    @FindBy(xpath = "//span/span")
    public WebElement Price;

    @FindBy(xpath = "//span[2]/span")
    public WebElement NewPrice;

    @FindBy(id = "qty")
    public WebElement Qty;

    @FindBy(id = "product-image")
    public WebElement ProductImage;

    @FindBy(css = "div.std > p")
    public WebElement Details;

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

    @FindBy(linkText = "Size Guide")
    public WebElement SizeGuide;

    @FindBy(linkText = "Be the first to review this product")
    public WebElement BeFirst;

    @FindBy(xpath = "//table[@id='downloadable-links-list']/tbody/tr/td[3]/label")
    public WebElement TrackName;

    @FindBy(xpath = "//div[3]/p[2]")
    public WebElement TextTasks;

    @FindBy(xpath = "//div[3]/p")
    public WebElement AreaTasks;

    @FindBy(xpath = "//li/a/img")
    public WebElement MiniImage;

    @Override
    protected void open() {
        // TODO Auto-generated method stub

    }


}
