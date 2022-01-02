package com.qa.democart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtil;

public class SearchResultsPage {

    private WebDriver driver;
    private ElementUtil elementutil;
    private By searchHeader = By.cssSelector("div#content h1");
    private By productResults = By.cssSelector("div.caption a");

    public SearchResultsPage(WebDriver driver) {

        this.driver = driver;
        elementutil = new ElementUtil(driver);
    }

    public String searchPageHeader()

    {
        return elementutil.doGetText(searchHeader);

    }

    public int getProductListsCount() {
        return elementutil.getelements(productResults).size();

    }

    public ProductInfoPage selectProduct(String mainProductName) {

        List<WebElement> productlist = elementutil.getelements(productResults);
        System.out.println("Main product is "+mainProductName);

        for (WebElement e : productlist) {
            System.out.println("iterating" +e.getText());
            if (e.getText().trim().contains(mainProductName)) {
                e.click();
                break;

            }

        }

        return new ProductInfoPage(driver);

    }

}
