package se.framework.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import se.framework.utils.configProperties;

import java.util.Random;

public class AnyPage extends Page {

    Random random = new Random();

    public AnyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

        int y = random.nextInt(1);

        if (y == 0) {
            int x = 1 + random.nextInt(6);
            System.out.println("Category -" + configProperties.getProperty("CLP.Url" + x));
            driver.get(System.getProperty("webdriver.base.url") + configProperties.getProperty("CLP.Url" + x));
             if (driver.getCurrentUrl() != System.getProperty("webdriver.base.url")) {
                int count = driver.findElements(By.cssSelector("a.quickview-btn")).size();
                System.out.println(count);
                int li, ul;
                if (count <= 3) {
                    ul = 1;
                    li = 1 + random.nextInt(count);
                } else {
                    ul = 1 + random.nextInt(count / 3);
                    li = 1 + random.nextInt(3);
                }
                driver.findElement(By.xpath("//ul[" + ul + "]/li[" + li + "]/a/img")).click();
            }
        } else {
            Random random = new Random();
            int x = 1 + random.nextInt(7);
            driver.get(System.getProperty("webdriver.base.url") + configProperties.getProperty("CLP.Url" + x));
            System.out.println("Category -" + configProperties.getProperty("CLP.Url" + x));
            //driver.get(configProperties.getProperty("HomePage.url") + configProperties.getProperty("CLP.Url" + x));
        }


    }

    @Override
    protected void openrandom() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CartPage clickAddToCart() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @FindBy(css = "button.button")
    public WebElement buttonSearchGo;

    @FindBy(id = "search")
    public WebElement fieldSearch;

    @Override
    public SearchPage search() throws InterruptedException {
        buttonSearchGo.submit();
        return PageFactory.initElements(driver, SearchPage.class);
    }

    @Override
    public void openAdmin() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
