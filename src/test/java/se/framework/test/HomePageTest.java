package se.framework.test;


import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import se.framework.pages.CartPage;
import se.framework.pages.HomePage;
import se.framework.utils.configProperties;

public class HomePageTest extends BasicTestCase {


    private HomePage HomePage = PageFactory.initElements(getWebDriver(), HomePage.class);
    private CartPage CartPage;

    @Test(enabled = true)
    public void testHomePageTitle() throws InterruptedException {
        System.out.println("testHomePageTitle");
        HomePage.open();
        assertEquals(configProperties.getProperty("HomePage.title"), driver.getTitle());
    }

    @Test(enabled = false)
    public void testSignUpForMailList() throws Exception {
        System.out.println("testSignUpForMailList");
        HomePage.open();
        HomePage.linkSingUpForMailingList.click();
        assertTrue(HomePage.form1SingUpForMailingList.isDisplayed());
        assertFalse(HomePage.form2SingUpForMailingList.isDisplayed());
        assertFalse(HomePage.form3SingUpForMailingList.isDisplayed());
        assertEquals("Email Newsletter Signup\nx Close", HomePage.headerForm1.getText());
        assertEquals("Mobile", HomePage.mobileForm1.getText());
        assertEquals("Email *", HomePage.email.getText());
        assertEquals("Country *", HomePage.country.getText());
        assertEquals("Postal Code *", HomePage.code.getText());
        assertEquals("Privacy Policy", HomePage.linkPrivacyPolicy.getText());
        assertEquals("Terms of Use", HomePage.linkTermsOfUse.getText());
        assertEquals("By submitting my information above, I acknowledge that I have reviewed and agreed to the Privacy Policy and Terms of Use, " +
                "and I agree to receive updates and marketing messages from time to time from Magento and its record label. For SMS messages, " +
                "I understand that message and data rates may apply, and that I may receive up to 2 SMS messages per week from Magento's mailing list.",
                HomePage.PrivacyText.getText());
        assertEquals("* Required Fields", HomePage.RequiredFields.getText());
        HomePage.submitForm1SingUpForMailingList(customer);
        for (int second = 0; ; second++) {
            if (second >= 10) Assert.fail("timeout");
            //TODO formContainer2 not fixing
            try {
                if (HomePage.form3SingUpForMailingList.isDisplayed()) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        assertFalse(HomePage.form1SingUpForMailingList.isDisplayed());
        //TODO formContainer2 not fixing
        assertTrue(HomePage.form2SingUpForMailingList.isDisplayed());
        assertFalse(HomePage.form3SingUpForMailingList.isDisplayed());
        assertEquals("For Wiz Khalifa news that is customized to you and your hometown such as local concerts and appearances," +
                " please fill out the form. At Atlantic Records, we are very concerned about our fans' privacy and do not share or sell your information to other third parties.",
                HomePage.mlistForm2Left.getText());
        assertEquals("Thanks!", HomePage.Thanks.getText());
        assertEquals("Email Newsletter Signup\nx Close", HomePage.headerForm1.getText());
        assertEquals("First Name", HomePage.firstname.getText());
        assertEquals("Mobile #", HomePage.mobileForm1.getText());
        assertEquals("Date of birth", HomePage.dateOfBirth.getText());
        assertEquals("Also, I want to join the Atlantic Records Newswire.", HomePage.additional.getText());
        assertTrue(HomePage.PresentmListForm2Right());
        assertEquals("By submitting my information above, I acknowledge that I have reviewed and agreed to the Privacy Policy and Terms of Use," +
                " and I agree to receive updates and marketing messages from time to time from Wiz Khalifa and his record label. For SMS messages," +
                " I understand that message and data rates may apply, and that I may receive up to 2 SMS messages per week from Wiz Khalifa's mailing list.",
                HomePage.mlistForm2Right.getText());
        assertEquals("Gender", HomePage.gender.getText());
        for (int second = 0; ; second++) {
            if (second >= 60) Assert.fail("timeout");
            try {
                if (HomePage.form3SingUpForMailingList.isDisplayed()) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        assertFalse(HomePage.form1SingUpForMailingList.isDisplayed());
        assertFalse(HomePage.form2SingUpForMailingList.isDisplayed());
        assertTrue(HomePage.form3SingUpForMailingList.isDisplayed());
        assertTrue(HomePage.ThankYouPresent());
        assertEquals("Thank you!", HomePage.thankyou.getText());
        assertEquals("Email Newsletter Signup\nx Close", HomePage.headerForm3.getText());
        // Form automaticly disapier and dont give chance to type data
    }

    @Test(enabled = false)
    public void AddToCartFromHomePageTest() throws InterruptedException {
        System.out.println("AddToCartFromHomePageTest");
        HomePage.open();
        String NameOfProduct = (HomePage.Product1.getText());
        String Price = HomePage.Price1.getText();
        String Qty = "1";
        CartPage = HomePage.clickAddToCart();
        assertTrue(CartPage.TextPresent("Your Shopping Cart"));
        assertTrue(CartPage.TextPresent("was added to your shopping cart."));
        assertTrue(CartPage.TextPresent("You have (1) item in your cart"));
        String s = CartPage.Replace(CartPage.ProductName.getText());
        assertEquals(NameOfProduct, CartPage.Replace(CartPage.ProductName.getText()));
        if (HomePage.SIZE != null) {
            assertEquals("Size:  " + HomePage.SIZE, CartPage.Size.getText());
        }
        assertEquals(Qty, CartPage.Qty.getAttribute("value"));
        assertEquals(Price, CartPage.PriceFromHome.getText());
        assertEquals(Price, CartPage.AmountFromHome.getText());
        assertEquals(Price, CartPage.Subtotal.getText());
        assertEquals(Price, CartPage.Subtotal.getText());
        assertEquals(Price, CartPage.Total.getText());
        CartPage.Remove.click();
        assertEquals("Your Shopping Cart", CartPage.Title.getText());
    }
}
