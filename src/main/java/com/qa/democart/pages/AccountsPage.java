package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class AccountsPage {

    private WebDriver driver;
    private ElementUtil elementutil;

    private By accSections = By.cssSelector("div#content h2");
    private By accHeaderText = By.cssSelector("div#logo h1 a");
    private By logoutLink = By.linkText("Logout");
    private By searchField = By.name("search");
    private By searchbtn = By.cssSelector("div#search button");

    public AccountsPage(WebDriver driver)

    {

        this.driver = driver;
        elementutil = new ElementUtil(driver);

    }

    public String getAccountPageTitle()

    {

        return elementutil.waitForTitleIs(Constants.ACCOUNT_PAGE_TITLE, 5);

    }

    public String getCurrentPageUrl()

    {

        return driver.getCurrentUrl();

    }

    public String getAccountPageHeader() {

        return elementutil.doGetText(accHeaderText);
    }

    public List<String> getAccountSectionsList() {

        List<WebElement> accSecList = elementutil.getelements(accSections);
        List<String> accSecListText = new ArrayList<String>();
        for (WebElement e : accSecList) {

            accSecListText.add(e.getText());
        }

        return accSecListText;

    }

    public boolean logoutLinkDisplayed() {

        return driver.findElement(logoutLink).isDisplayed();
    }

    public SearchResultsPage doSearch(String searchText)

    {
        System.out.println("Searching the product :" + searchText);
        
        elementutil.dosendkeys(searchField,searchText);
        elementutil.doClick(searchbtn);
        return new SearchResultsPage(driver);

    }
}
