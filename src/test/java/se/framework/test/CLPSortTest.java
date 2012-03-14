package se.framework.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.apache.bcel.verifier.statics.Pass1Verifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import se.framework.pages.CLPage;


public class CLPSortTest extends BasicTestCase {

    private CLPage CLPage = PageFactory.initElements(getWebDriver(), CLPage.class);


    @Test(enabled = true)
    public void testSortCLPGuest() throws Exception {
        System.out.println("testSortByNameCLPGuest");
        CLPage.openrandom();
        assertEquals("Sort By", CLPage.SortBy.getText());
        assertEquals("Position", CLPage.selectedSortBy.getText());
        //CLPage.fieldSortBy.click();
        //assertEquals("Most recently added", CLPage.fieldSortBy.getText());
        new Select(CLPage.fieldSortBy).selectByVisibleText("We Love");
        //CLPage.linkTopSellers.click();
        assertEquals("We Love", CLPage.selectedSortBy.getText());
        //CLPage.fieldSortBy.click();
        new Select(CLPage.fieldSortBy).selectByVisibleText("Name");
        int countUl;
        Integer countProd = CLPage.CountOfProducts();
        if (countProd % 4 == 0) {
            countUl = countProd / 4;
        } else {
            countUl = countProd / 4 + 1;
        }
        for (int i = 1; i <= countUl; i++) {
            Integer countLi = CLPage.CountOfLi(i);
            for (int y = 1; y <= countLi - 1; y++) {
                assertTrue(CLPage.ProductNText(i, y).compareToIgnoreCase(CLPage.ProductNText(i, y + 1)) <= 0);
            }
        }
        /*CLPage.fieldSortBy.click();
        CLPage.linkZA.click();
        if (countProd % 4 == 0) {
            countUl = countProd / 4;
        } else {
            countUl = countProd / 4 + 1;
        }
        for (int i = 1; i <= countUl; i++) {
            Integer countLi = CLPage.CountOfLi(i);
            for (int y = 1; y <= countLi - 1; y++) {
                assertTrue(CLPage.ProductNText(i, y).compareToIgnoreCase(CLPage.ProductNText(i, y + 1)) >= 0);
            }
        }
        CLPage.fieldSortBy.click();*/
        new Select(CLPage.fieldSortBy).selectByVisibleText("Price");
        if (countProd % 4 == 0) {
            countUl = countProd / 4;
        } else {
            countUl = countProd / 4 + 1;
        }
        for (int i = 1; i <= countUl; i++) {
            Integer countLi = CLPage.CountOfLi(i);
            for (int y = 1; y <= countLi - 1; y++) {
                assertTrue(CLPage.ProductNPrice(i, y) >= CLPage.ProductNPrice(i, y + 1));
            }
        }
        /*CLPage.fieldSortBy.click();
        CLPage.linkLowHigh.click();
        if (countProd % 4 == 0) {
            countUl = countProd / 4;
        } else {
            countUl = countProd / 4 + 1;
        }
        for (int i = 1; i <= countUl; i++) {
            Integer countLi = CLPage.CountOfLi(i);
            for (int y = 1; y <= countLi - 1; y++) {
                assertTrue(CLPage.ProductNPrice(i, y) <= CLPage.ProductNPrice(i, y + 1));
            }
        }*/
    }

}
