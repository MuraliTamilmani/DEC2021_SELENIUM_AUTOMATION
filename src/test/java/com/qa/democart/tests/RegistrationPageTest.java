package com.qa.democart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {

    @BeforeClass
    public void regPageSetup() {
        regPage = lp.clickRegisterPage();

    }
    
    public String getRandomNumber()
    
    {
        Random random=new Random();
        String randomEmail="testautomation"+random.nextInt(5000)+"@gmail.com";
        System.out.println(randomEmail);
        return randomEmail;
        
        
        
    }

    @DataProvider
    public Object[][] getRegistrationData() {
        return new Object[][] {

                { "Murali124", "L1", "321424432", "test123", "Yes" },
                { "Kumar", "L2","32453252", "welcome123", "No" }

        };

    }

    @Test(dataProvider = "getRegistrationData")
    public void registrationTest(String firstname, String lastname,String telephone, String password,
            String subscribe) {

        Assert.assertTrue(regPage.doRegistration(firstname, lastname, getRandomNumber(), telephone, password, subscribe));

    }
}
