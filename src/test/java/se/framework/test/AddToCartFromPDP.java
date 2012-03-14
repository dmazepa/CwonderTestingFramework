package se.framework.test;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import se.framework.pages.CartPage;
import se.framework.pages.PDPage;

import java.lang.String;

public class AddToCartFromPDP extends BasicTestCase {

    private PDPage PDPage = PageFactory.initElements(getWebDriver(), PDPage.class);
    private CartPage CartPage;
    String Size;

    @Test
    public void testAddToCartFromPDP() throws Exception {
        System.out.println("testAddToCartFromPDP");
        PDPage.openrandom();
        if (PDPage.isElementPresent(PDPage.SizeGuide)) {
            driver.findElement(By.xpath("//a[2]/span/span")).click();
            new Select(PDPage.selectorColor).selectByValue("337");
            String Size = PDPage.getSelectedSize(PDPage.Size);
        }
        String NameOfProduct = PDPage.ProductName.getText();
        String Price;
        if (PDPage.isElementPresent(PDPage.NewPrice)){
            Price = PDPage.NewPrice.getText();
        }else {
            Price = PDPage.Price.getText();
        }
        String Qty = PDPage.Qty.getAttribute("value");
        CartPage = PDPage.clickAddToCart();
        //assertTrue(CartPage.TextPresent("Your Shopping Cart"));   Not used

        assertTrue(CartPage.TextPresent(NameOfProduct + " was added to your shopping cart."));
        // assertTrue(CartPage.TextPresent("You have (1) item in your cart"));  Not used
        assertEquals(NameOfProduct, CartPage.ProductName.getText());
        if (Size != null) {
            assertEquals("Size:  " + Size, CartPage.Size.getText());
        }
        assertEquals(Qty, CartPage.Qty.getAttribute("value"));
        assertEquals(Price, CartPage.Price.getText());
        assertEquals(Price, CartPage.SubtotalTable.getText());
        assertEquals(Price, CartPage.Subtotal.getText());

        //CartPage.waitForElementPresent(CartPage.Remove);
        //CartPage.Remove.click();
        //assertEquals("Your Shopping Cart", CartPage.Title.getText());

    }

}
