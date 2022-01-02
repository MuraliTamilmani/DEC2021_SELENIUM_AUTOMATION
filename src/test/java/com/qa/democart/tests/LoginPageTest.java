package com.qa.democart.tests;

import static org.testng.Assert.assertTrue;

import java.awt.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.pages.AccountsPage;
import com.qa.democart.utils.Constants;
import com.qa.democart.utils.Errors;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageTitleTest() {

        String lptitle = lp.loginPageTitle();
        Assert.assertEquals(lptitle, Constants.LOGIN_PAGE_TITLE, Errors.TITLE_ERROR_MSG);

    }

    @Test(priority = 2)
    public void loginPageHeaderTest() {

        String headerText = lp.getLoginPageHeaderText();
        Assert.assertEquals(headerText, Constants.PAGE_HEADER, Errors.HEADER_ERROR_MSG);

    }

    @Test(priority = 3)
    public void forgotPasswordLinkExist() {

        boolean fpflag = lp.forgotPasswordLinkDisplayed();
        Assert.assertTrue(fpflag);

    }

    @Test(priority = 4)
    public void loginTest() {
        AccountsPage accpage = lp.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        Assert.assertTrue(accpage.logoutLinkDisplayed());
        System.out.println("Is Logout link exist " +accpage.logoutLinkDisplayed());
        
    }

    @Test(priority = 5)

    public void linksTest()

    {

        int totalLinks = lp.getLinks().size();
        System.out.println("total links are " + totalLinks);
        Assert.assertEquals(totalLinks, Constants.LOGIN_PAGE_MAINLINKS_COUNT);

    }

    @Test(priority = 6)

    public void menuLinksTest()

    {

        int totalMenuLinks = lp.getMenuLinks().size();
        System.out.println("total menu links are " + totalMenuLinks);
        Assert.assertEquals(totalMenuLinks, Constants.LOGIN_PAGE_MENUNLINKS_COUNT);

    }

}
