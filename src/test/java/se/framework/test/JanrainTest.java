package se.framework.test;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import se.framework.pages.CreateAccountPage;
import se.framework.pages.MyAccountPage;
import se.framework.pages.RegisterCustomerPage;

import static org.testng.Assert.assertEquals;

public class JanrainTest extends BasicTestCase {

    private CreateAccountPage CreateAccountPage = PageFactory.initElements(getWebDriver(), CreateAccountPage.class);
    private RegisterCustomerPage RegisterCustomer = PageFactory.initElements(getWebDriver(), RegisterCustomerPage.class);
    private MyAccountPage MyAccountPage;


    @Test(enabled = false)
    public void testJainrainFromRegisterCustomers() throws InterruptedException {

        RegisterCustomer.open();
        RegisterCustomer.emblemFacebook.click();
        RegisterCustomer.waitForElementVisible(RegisterCustomer.formSignInWith);
        MyAccountPage = RegisterCustomer.registerUser("test3@speroteck.com", "testthis");
        MyAccountPage.waitForElementPresent(MyAccountPage.successMsg);
        assertEquals("Thank you for registering with Webstore. You will receive a confirmation email shortly.", MyAccountPage.successMsg.getText());
        assertEquals("Hello, Kolya Tam!", MyAccountPage.welcomeMsg.getText());
        assertEquals("Kolya Tam\ntest3@speroteck.com\nChange Password", MyAccountPage.contactInfomation.getText());
        MyAccountPage.removeJanrainID.click();
        Thread.sleep(10000);
        DeleteCreatedCustomers("test3@speroteck.com");
    }

    @Test(enabled = false)
    public void testJainrainFromCreateAccount() throws InterruptedException {

        CreateAccountPage.open();
        CreateAccountPage.emblemFacebook.click();
        RegisterCustomer.waitForElementVisible(RegisterCustomer.formSignInWith);
        /*MyAccountPage = RegisterCustomer.registerUser("test3@speroteck.com", "testthis");
        MyAccountPage.waitForElementPresent(MyAccountPage.successMsg);
        assertEquals("Thank you for registering with Webstore. You will receive a confirmation email shortly.", MyAccountPage.successMsg.getText());
        assertEquals("Hello, Kolya Tam!", MyAccountPage.welcomeMsg.getText());
        assertEquals("Kolya Tam\ntest3@speroteck.com\nChange Password", MyAccountPage.contactInfomation.getText());
        MyAccountPage.removeJanrainID.click();
        Thread.sleep(10000);
        DeleteCreatedCustomers("test3@speroteck.com");*/


    }

    public void DeleteCreatedCustomers(String email) throws InterruptedException {
        RegisterCustomer.openAdmin();
        RegisterCustomer.fieldAdminLogin.sendKeys("admin");
        RegisterCustomer.fieldAdminPassword.sendKeys("qwer1234");
        RegisterCustomer.buttonSubmitAdmin.click();

        RegisterCustomer.filterImail.sendKeys(email);

        RegisterCustomer.buttonSearch.click();
        Thread.sleep(4000);
        RegisterCustomer.selectAll.click();
        new Select(RegisterCustomer.selectAction).selectByVisibleText("Delete");
        RegisterCustomer.buttonSubmitCustomer.click();
        driver.switchTo().alert().accept();
    }
}
