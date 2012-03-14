package se.framework.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import se.framework.pages.PDPClouth;

public class PDPClothTest extends BasicTestCase {
    private PDPClouth PDPCloth = PageFactory.initElements(getWebDriver(), PDPClouth.class);

    @Test(enabled = false)
    public void testPDPCloth() throws Exception {
        System.out.println("testPDPCloth");
        PDPCloth.openrandom();
        if (PDPCloth.isElementPresent(PDPCloth.Size)) {
            System.out.print(driver.getCurrentUrl());
            assertTrue(PDPCloth.isElementPresent(PDPCloth.ProductName));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.Price));
            assertEquals("Size:", PDPCloth.getSelectedSize(PDPCloth.Size));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.SelectSize));
            assertEquals("1", PDPCloth.Qty.getAttribute("value"));
            assertEquals("Quantity", PDPCloth.QtyText.getText());
            assertTrue(PDPCloth.isElementPresent(PDPCloth.buttonAddToCart));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.AddToWishlist));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.ProductImage));
            if (PDPCloth.isElementPresent(PDPCloth.Details)) {
                assertTrue(PDPCloth.isElementPresent(PDPCloth.Details));
            }
            assertTrue(PDPCloth.isElementPresent(PDPCloth.MiniImage));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.ShareBox));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.RatingBox));
            assertEquals("Be the first to review this product", PDPCloth.BeFirst.getText());
        } else {
            System.out.print(driver.getCurrentUrl());
            assertTrue(PDPCloth.isElementPresent(PDPCloth.ProductName));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.Price));
            assertEquals("Quantity", PDPCloth.QtyText.getText());
            assertEquals("1", PDPCloth.Qty.getAttribute("value"));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.buttonAddToCart));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.AddToWishlist));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.ProductImage));
            if (PDPCloth.isElementPresent(PDPCloth.Details)) {
                assertTrue(PDPCloth.isElementPresent(PDPCloth.Details));
            }
            assertTrue(PDPCloth.isElementPresent(PDPCloth.MiniImage));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.ShareBox));
            assertTrue(PDPCloth.isElementPresent(PDPCloth.RatingBox));
            assertEquals("Be the first to review this product", PDPCloth.BeFirst.getText());
        }

    }
}
