package se.framework.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import se.framework.pages.PDPage;

public class PDPMusicTest extends BasicTestCase {
    private PDPage PDPage = PageFactory.initElements(getWebDriver(), PDPage.class);

    @Test(enabled = false)
    public void testPDPMusic() throws Exception {
        System.out.println("testPDPMusic");
        PDPage.openmusic();
        assertTrue(PDPage.isElementPresent(PDPage.buttonAddToCart));
        assertTrue(PDPage.isElementPresent(PDPage.AddToWishlist));
        assertEquals("Quantity", PDPage.QtyText.getText());
        assertEquals("1", PDPage.Qty.getAttribute("value"));
        if (PDPage.isElementPresent(PDPage.RaleaseDate)) {
            assertTrue(PDPage.RaleaseDate.getText().matches("^Release Date: [\\s\\S]*$"));
        }
        assertTrue(PDPage.isElementPresent(PDPage.Price));
        assertTrue(PDPage.isElementPresent(PDPage.ProductName));
        assertTrue(PDPage.isElementPresent(PDPage.ProductImage));
        //assertTrue(PDPage.isElementPresent(PDPage.Details));
        assertTrue(PDPage.TextPresent("Track Listing"));
        assertTrue(PDPage.isElementPresent(PDPage.AreaTasks));
        assertTrue(PDPage.isElementPresent(PDPage.MiniImage));
        assertEquals("Track Listing", PDPage.TrackListing.getText());
        assertEquals("1", PDPage.TrackNumber.getText());
        assertTrue(PDPage.isElementPresent(PDPage.TrackNumber));
        assertTrue(PDPage.isElementPresent(PDPage.ShareBox));
        assertTrue(PDPage.isElementPresent(PDPage.RatingBox));
        assertEquals("Be the first to review this product", PDPage.BeFirst.getText());

        //TODO Test for product that contains 1 track
    }
}
