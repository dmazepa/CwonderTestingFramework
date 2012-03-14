package se.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import se.framework.data.userData;
import se.framework.utils.configProperties;


public class HomePage extends Page {

    public String SIZE;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(System.getProperty("webdriver.base.url"));
        //driver.get(configProperties.getProperty("HomePage.url"));
    }

    @FindBy(id = "openSignUpMailingList")
    public WebElement linkSingUpForMailingList;

    @FindBy(xpath = "//div[@id='formContainer1']")
    public WebElement form1SingUpForMailingList;

    @FindBy(xpath = "//div[@id='formContainer2']")
    public WebElement form2SingUpForMailingList;

    @FindBy(xpath = "//div[@id='formContainer3']")
    public WebElement form3SingUpForMailingList;

    @FindBy(xpath = "//div[@id='formContainer1']/h4")
    public WebElement headerForm1;

    @FindBy(xpath = "//div[@id='mListMobileForm1']/div/label")
    public WebElement mobileForm1;

    @FindBy(xpath = "//div[@id='mListEmailForm1']/div/label")
    public WebElement email;

    @FindBy(xpath = "//div[4]/div/label")
    public WebElement country;

    @FindBy(xpath = "//div[@id='mListZipForm1']/div/label")
    public WebElement code;

    @FindBy(id = "mListEmail1")
    public WebElement emailfield;

    @FindBy(id = "mListMobile1")
    public WebElement mobilefield;

    @FindBy(id = "mListZip1")
    public WebElement codefield;

    @FindBy(linkText = "Privacy Policy")
    public WebElement linkPrivacyPolicy;

    @FindBy(linkText = "Terms of Use")
    public WebElement linkTermsOfUse;

    @FindBy(id = "privacyText")
    public WebElement PrivacyText;

    @FindBy(xpath = "//div[@id='formContainer1']/div[5]/span")
    public WebElement RequiredFields;

    @FindBy(id = "mListCountry1")
    public WebElement fieldCountry;

    @FindBy(css = "a.submit.button")
    public WebElement linkSubmit;


    public void submitForm1SingUpForMailingList(userData ud) {
        type(emailfield, ud.email);
        type(mobilefield, ud.mobile);
        type(codefield, ud.code);
        select(fieldCountry, ud.country);
        linkSubmit.click();
    }

    @FindBy(xpath = "//div[@id='mlistForm2Left']/p")
    public WebElement mlistForm2Left;

    @FindBy(xpath = "//div[@id='mlistForm2Left']/h4")
    public WebElement Thanks;

    @FindBy(xpath = "//div[@id='mlistForm2Right']/div/div/div/label")
    public WebElement firstname;

    @FindBy(xpath = "//div[@id='mlistForm2Right']/div/div[4]/div/label")
    public WebElement dateOfBirth;

    @FindBy(css = "#additionalIds > label")
    public WebElement additional;

    @FindBy(xpath = "//div[@id='mlistForm2Right']/div/div[7]")
    public WebElement mlistForm2Right;

    @FindBy(xpath = "//div[@id='mlistForm2Right']/div/div[6]/a")
    public WebElement ElementThankYou;

    @FindBy(xpath = "//div[@id='formContainer3']/h4/a")
    public WebElement thankyou;

    @FindBy(xpath = "//div[@id='formContainer3']/h4")
    public WebElement headerForm3;

    @FindBy(xpath = "//div[@id='mlistForm2Right']/div/div[2]/div/label")
    public WebElement gender;

    @FindBy(xpath = "//li[2]/h3/a")
    public WebElement Product1;

    @FindBy(xpath = "//div[2]/span/a/span")
    public WebElement Price1;

    @Override
    public CartPage clickAddToCart() throws InterruptedException {
        buttonAddToCart.click();
        if (TextPresent("Your Shopping Cart")) {
            return PageFactory.initElements(driver, CartPage.class);
        } else {
            PDPage PDPage = PageFactory.initElements(driver, PDPage.class);
            SelectSizeRandom(PDPage.Size);
            SIZE = PDPage.getSelectedSize(PDPage.Size);
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


    public boolean ThankYouPresent() {
        return isElementPresent(ElementThankYou);
    }

    public boolean PresentmListForm2Right() {
        return isElementPresent(mlistForm2Right);
    }

    @Override
    protected void openrandom() {
        // TODO Auto-generated method stub

    }

    @FindBy(xpath = "//div[3]/button")
    public WebElement buttonAddToCart;


}
