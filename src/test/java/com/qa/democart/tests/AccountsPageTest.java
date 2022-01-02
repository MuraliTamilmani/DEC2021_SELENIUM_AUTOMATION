package com.qa.democart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.pages.AccountsPage;
import com.qa.democart.utils.Constants;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void accPageSetup()

    {
        accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test
    public void accPageTitleTest()

    {
        String accPageTitle = accPage.getAccountPageTitle();
        System.out.println("Page title is " + accPageTitle);
        Assert.assertEquals(accPageTitle, Constants.ACCOUNT_PAGE_TITLE);

    }

    @Test
    public void accPageHeaderTest() {
        String accPageHeader = accPage.getAccountPageHeader();
        System.out.println("Header text is " + accPageHeader);
        Assert.assertEquals(accPageHeader, Constants.PAGE_HEADER);

    }

    @Test
    public void accSectionsListTest() {
        List<String> accSectionsList = accPage.getAccountSectionsList();
        System.out.println("Actual Sections " + accSectionsList);
        Assert.assertEquals(accSectionsList, Constants.EXPECTED_ACCOUNT_SECTION_LIST);

    }

    @Test
    public void logOutLinkExistTest() {

        Assert.assertTrue(accPage.logoutLinkDisplayed());
    }

    @DataProvider
    public Object[][] getSearchData() {
        return new Object[][] {

                { "MacBook Pro" }, { "Apple" }, { "MacBook Air" }

        };

    }

    @Test(dataProvider = "getSearchData")
    public void productSearchTest(String productName) {
        searchresPage = accPage.doSearch(productName);
        String resultheader = searchresPage.searchPageHeader();
        System.out.println("SearchHeadertext " + resultheader);
        Assert.assertTrue(resultheader.contains(productName));

    }

    @DataProvider
    public Object[][] getProductSelectData() {
        return new Object[][] {

                {"MacBook","MacBook Pro" }, { "Apple","Apple Cinema 30\"" }, { "MacBook","MacBook Air" }

        };

    }

    @Test(dataProvider = "getProductSelectData")
    public void selectProductTest(String productName,String mainProductName) {
        
        searchresPage = accPage.doSearch(productName);
        prodInfoPage= searchresPage.selectProduct(mainProductName);
        String headerText= searchresPage.searchPageHeader();
        Assert.assertEquals(headerText, mainProductName);
       
        

    }
}
