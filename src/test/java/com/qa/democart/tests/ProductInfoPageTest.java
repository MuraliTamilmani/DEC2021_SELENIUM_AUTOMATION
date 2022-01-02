package com.qa.democart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoPageTest extends BaseTest {

    @BeforeClass

    public void productInfoPageSetup()

    {
        accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test
    public void productImageTest() {
        searchresPage = accPage.doSearch("Macbook");
        prodInfoPage = searchresPage.selectProduct("MacBook Pro");
        Assert.assertEquals(prodInfoPage.getProductImageCount(), 4);

    }

    @Test
    public void productInfoTest() {

        searchresPage = accPage.doSearch("Macbook");
        prodInfoPage = searchresPage.selectProduct("MacBook Pro");
        Map<String, String> actprodInfo = prodInfoPage.productInfoMap();
        Assert.assertEquals(actprodInfo.get("name"),"MacBook Pro");
        Assert.assertEquals(actprodInfo.get("Brand"),"Apple");
        Assert.assertEquals(actprodInfo.get("Product Code"),"Product 18");
        Assert.assertEquals(actprodInfo.get("Reward Points"),"800");
        Assert.assertEquals(actprodInfo.get("price"),"$2,000.00");
    }
    @Test
    public void addToCartTest() throws InterruptedException
    {
        searchresPage = accPage.doSearch("Macbook");
        prodInfoPage = searchresPage.selectProduct("MacBook Pro");
        String msg=prodInfoPage.doAddToCart();
        System.out.println(msg);
        Assert.assertTrue(msg.contains("Success: You have added MacBook Pro to your shopping cart"));
               
    }
}
