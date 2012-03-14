package se.framework.pages;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import se.framework.utils.configProperties;


public class CLPage extends Page {

    public String SIZE;
    public String PRODUCTNAME;
    public String PRICE;


    public CLPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openrandom() {
        Random random = new Random();
        int x = 1 + random.nextInt(6);
        driver.get(System.getProperty("webdriver.base.url") + configProperties.getProperty("CLP.Url" + x));
        System.out.println("Category -" + configProperties.getProperty("CLP.Url" + x));
        //driver.get(configProperties.getProperty("HomePage.url")+configProperties.getProperty("CLP.Url"+x));
    }

    @FindBy(css = "div.sort-by > label")
    public WebElement SortBy;

    @FindBy(css = "select")
    public WebElement fieldSortBy;

    @FindBy(xpath = "//select/option[@selected]")
    public WebElement selectedSortBy;

    @FindBy(linkText = "Top sellers")
    public WebElement linkTopSellers;

    @FindBy(linkText = "Name: A-Z")
    public WebElement linkAZ;


    @FindBy(xpath = "//h3/a")
    public WebElement Product1;

    @FindBy(xpath = "//li[2]/h3/a")
    public WebElement Product2;

    @FindBy(xpath = "//li[3]/h3/a")
    public WebElement Product3;

    @FindBy(xpath = "//li[4]/h3/a")
    public WebElement Product4;

    @FindBy(linkText = "Name: Z-A")
    public WebElement linkZA;

    @FindBy(linkText = "Price: High-Low")
    public WebElement linkHighLow;

    @FindBy(xpath = "//li[1]/div[2]/span/a/span")
    public WebElement Price1;

    @FindBy(xpath = "//li[2]/div[2]/span/a/span")
    public WebElement Price2;

    @FindBy(xpath = "//li[3]/div[2]/span/a/span")
    public WebElement Price3;

    @FindBy(xpath = "//li[4]/div[2]/span/a/span")
    public WebElement Price4;

    @FindBy(linkText = "Price: Low-High")
    public WebElement linkLowHigh;

    public int getNumber(WebElement w) {
        return Integer.parseInt(w.getText().replaceAll("[^0-9]", ""));
    }


    @Override
    public CartPage clickAddToCart() throws InterruptedException {
        Random random = new Random();
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
        PRODUCTNAME = driver.findElement(By.xpath("//ul[" + ul + "]/li[" + li + "]/h3/a")).getText();
        PRICE = driver.findElement(By.xpath("//ul[" + ul + "]/li[" + li + "]/div[2]/span/a/span")).getText();
        driver.findElement(By.xpath("//ul[" + ul + "]/li[" + li + "]/a/img")).click();
        if (TextPresent("Your Shopping Cart")) {
            return PageFactory.initElements(driver, CartPage.class);
        } else {
            PDPage PDPage = PageFactory.initElements(driver, PDPage.class);
            if (PDPage.isElementPresent(PDPage.Size)) {
                SelectSizeRandom(PDPage.Size);
                SIZE = PDPage.getSelectedSize(PDPage.Size);
            }
            return PDPage.clickAddToCart();

        }
    }

    @Override
    protected SearchPage search() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void openAdmin() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void open() {
        // TODO Auto-generated method stub

    }

    public int CountOfProducts() {
        return driver.findElements(By.xpath("//ul/li/div/button")).size();
    }

    public int CountOfLi(int ul) {
        return driver.findElements(By.xpath("//ul[" + ul + "]/li/h3/a")).size();
    }

    public String ProductNText(int i, int y) {
        return driver.findElement(By.xpath("//ul[" + i + "]/li[" + y + "]/h3/a")).getText();
    }

    public int ProductNPrice(int i, int y) {
        return getNumber(driver.findElement(By.xpath("//ul[" + i + "]/li[" + y + "]/div[2]/span/a/span")));
    }


}
