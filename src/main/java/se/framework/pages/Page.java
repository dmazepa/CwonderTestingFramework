package se.framework.pages;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.String;

import static com.sun.corba.se.impl.orbutil.CorbaResourceUtil.getText;
import static com.thoughtworks.selenium.SeleneseTestBase.fail;
import static java.lang.Thread.sleep;

public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected Page() {
    }

    protected void type(WebElement w, String s) {
        w.clear();
        w.sendKeys(s);
    }

    protected abstract void open();

    protected abstract void openrandom() throws InterruptedException;


    protected void select(WebElement w, String s) {
        new Select(w).selectByVisibleText(s);
    }


    protected void SelectLabel(WebElement w, String s) {
        new Select(w).selectByVisibleText(s);
    }

    public Boolean waitForElementPresent(WebElement w) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 10) fail("timeout");
            try {
                if (isElementPresent(w)) break;
            } catch (Exception e) {
                return false;
            }
            Thread.sleep(1000);


        }

        return true;
    }


    public boolean isElementPresent(WebElement w) {
        try {
            w.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void assertTextPresent(String s) {
    }

    public boolean TextPresent(String s) {
        return driver.getPageSource().contains(s);
    }

    public abstract CartPage clickAddToCart() throws InterruptedException;


    public void SelectSizeRandom(WebElement w) {
        String[] Value;
        Value = new String[6];
        Value[1] = "6";
        Value[2] = "5";
        Value[3] = "4";
        Value[4] = "18";
        Value[5] = "410";
        Random random = new Random();
        int x = 1 + random.nextInt(5);
        try {
            new Select(w).selectByValue(Value[x]);
        } catch (Exception e) {
            SelectSizeRandom(w);
        }

    }

    public String getSelectedSize(WebElement w) {
        String[] Size;
        Size = new String[411];
        Size[0] = "Please Select";
        Size[6] = "Small";
        Size[5] = "Medium";
        Size[4] = "Large";
        Size[18] = "X-Large";
        Size[410] = "XX-Large";
        int value = Integer.parseInt(w.getAttribute("value"));
        return Size[value];
    }

    public String Replace(String str) {
        StringBuilder b = new StringBuilder(str);
        int i = 0;
        do {
            b.replace(i, i + 1, b.substring(i, i + 1).toUpperCase());
            i = b.indexOf(" ", i) + 1;
        } while (i > 0 && i < b.length());
        return b.toString();
    }


    protected abstract SearchPage search() throws InterruptedException;

    public Boolean waitForElementVisible(WebElement w) throws InterruptedException {
        for (int second = 0; ; second++)

        {
            if (second >= 60) fail("timeout");
            try {
                if (w.isDisplayed()) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        return true;
    }

    public abstract void openAdmin();


}
