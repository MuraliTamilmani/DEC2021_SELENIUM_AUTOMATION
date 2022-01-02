package com.qa.democart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtil;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtil elementutil;
    private By productHeaderText = By.cssSelector("div#content h1");
    private By productImageCount = By.cssSelector("ul.thumbnails img");
    private By productInfoData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
    private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
    private By quantity = By.id("input-quantity");
    private By addToCartBtn = By.id("button-cart");
    private Map<String, String> productInfoMap;
    private By successMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");

    public ProductInfoPage(WebDriver driver) {

        this.driver = driver;
        elementutil = new ElementUtil(driver);
    }

    public String getProductHeaderText() {
        return elementutil.doGetText(productHeaderText);

    }

    public int getProductImageCount() {

        return elementutil.getelements(productImageCount).size();
    }

    public Map<String, String> productInfoMap() {

        productInfoMap = new HashMap<String, String>();
        productInfoMap.put("name", getProductHeaderText());

        List<WebElement> productMetaData = elementutil.getelements(productInfoData);

        // meta data
//        Brand: Apple
//        Product Code: Product 17
//        Reward Points: 700
//        Availability: Out Of Stock
        for (WebElement e : productMetaData) {
            String meta[] = e.getText().split(":");
            String metaKey = meta[0].trim();
            String metaValue = meta[1].trim();
            productInfoMap.put(metaKey, metaValue);

        }

        // pricelist

        List<WebElement> productPrice = elementutil.getelements(productPriceData);
        System.out.println("Total product price list " + productPrice.size());

        String price = productPrice.get(0).getText().trim();
        String ExTax = productPrice.get(1).getText().trim();

        productInfoMap.put("price", price);
        productInfoMap.put("ExTaxPrice", ExTax);
        return productInfoMap;
    }

    public String doAddToCart() throws InterruptedException

    {
        elementutil.doClick(addToCartBtn);
        
       return elementutil.waitForVisibilityOfElementandGetText(successMsg,2000);

    }

}
