package com.qa.democart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.democart.factory.DriverFactory;
import com.qa.democart.pages.AccountsPage;
import com.qa.democart.pages.LoginPage;
import com.qa.democart.pages.ProductInfoPage;
import com.qa.democart.pages.RegistrationPage;
import com.qa.democart.pages.SearchResultsPage;
import com.qa.democart.utils.ElementUtil;

public class BaseTest {

    DriverFactory df;
    WebDriver driver;
    Properties prop;
    LoginPage lp;
    ElementUtil eu;
    AccountsPage accPage;
    SearchResultsPage searchresPage;
    ProductInfoPage prodInfoPage;
    RegistrationPage regPage;

 

    @BeforeTest
    public void setUp() {

        df = new DriverFactory();
        prop=df.initproperties();
        driver = df.initDriver(prop);
        lp = new LoginPage(driver);

    }

    @AfterTest
    public void tearDown() {
       // driver.quit();
    }
}
