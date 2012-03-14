package se.framework.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import se.framework.pages.CartPage;
import se.framework.pages.CLPage;


public class AddToCartFromCLPTest extends BasicTestCase {

    private CLPage CLPage = PageFactory.initElements(getWebDriver(), CLPage.class);
    private CartPage CartPage;

    @Test(enabled = false) //not used
    public void testAddToCartFromCLP() throws Exception {
        System.out.println("testAddToCartFromCLP");
        CLPage.openrandom();
        String Qty = "1";
        CartPage = CLPage.clickAddToCart();
        assertTrue(CartPage.TextPresent("Your Shopping Cart"));
        assertTrue(CartPage.TextPresent(CLPage.PRODUCTNAME + " was added to your shopping cart."));
        assertTrue(CartPage.TextPresent("You have (1) item in your cart"));
        assertEquals(CLPage.PRODUCTNAME, CartPage.ProductName.getText());
        if (CLPage.SIZE != null) {
            assertEquals("Size:  " + CLPage.SIZE, CartPage.Size.getText());
        }
        assertEquals(Qty, CartPage.Qty.getAttribute("value"));
        assertEquals(CLPage.PRICE, CartPage.Price.getText());
        //assertEquals(CLPage.PRICE, CartPage.Amount.getText());
        assertEquals(CLPage.PRICE, CartPage.Subtotal.getText());
        assertEquals(CLPage.PRICE, CartPage.Total.getText());
        CartPage.waitForElementPresent(CartPage.Remove);
        CartPage.Remove.click();
        assertEquals("Your Shopping Cart", CartPage.Title.getText());
    }
}
