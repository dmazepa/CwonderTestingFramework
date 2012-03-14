package se.framework.test;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import se.framework.pages.AnyPage;

import se.framework.pages.SearchPage;

public class ForAllPagesTest extends BasicTestCase {

    private AnyPage AnyPage = PageFactory.initElements(getWebDriver(), AnyPage.class);
    private SearchPage SearchPage;

    @Test(enabled = true)
    public void SearchNoResultsTest() throws InterruptedException {
        System.out.println("SearchTest");
        AnyPage.open();
        AnyPage.fieldSearch.sendKeys("kaka");
        SearchPage = AnyPage.search();
        assertEquals("Search results for 'kaka'", SearchPage.textSearchResults.getText());
        assertEquals("Your search returns no results.", SearchPage.areaSearchResults.getText());
        assertEquals("Search results for: 'kaka'", SearchPage.Strong.getText());
        assertEquals("C.Wonder", SearchPage.bottonSearch.getText());
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididuntut labore et dolore magna aliqua lorem ipsum dolor sit amet...", SearchPage.bottonDescription.getText());

    }

    @Test(enabled = false)
    public void SearchWithResultsTest() throws InterruptedException {
        System.out.println("SearchTest");
        AnyPage.open();
        AnyPage.fieldSearch.sendKeys("Rock");
        SearchPage = AnyPage.search();
        assertEquals("Search results for 'kaka'", SearchPage.textSearchResults.getText());
        assertEquals("Your search returns no results.", SearchPage.areaSearchResults.getText());
        assertEquals("Search results for: 'kaka'", SearchPage.Strong.getText());
        assertEquals("C.Wonder", SearchPage.bottonSearch.getText());
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididuntut labore et dolore magna aliqua lorem ipsum dolor sit amet...", SearchPage.bottonDescription.getText());
    }
}
