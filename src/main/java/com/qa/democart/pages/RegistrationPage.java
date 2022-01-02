package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class RegistrationPage {

    WebDriver driver;
    ElementUtil elementutil;

    private By firstname = By.name("firstname");
    private By lastname = By.name("lastname");
    private By email = By.name("email");
    private By telephone = By.name("telephone");
    private By password = By.name("password");
    private By confirmpwd = By.name("confirm");
    private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
    private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
    private By agreePolicy = By.xpath("//input[@name='agree']");
    private By submitBtn = By.xpath("//input[@type='submit']");
    private By regSuccessMsg=By.xpath("//div[@id='content']/h1");
    private By logoutLink=By.linkText("Logout");
    private By registrationLink=By.linkText("Register");

    
    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
        elementutil = new ElementUtil(driver);
    }

    public boolean doRegistration(String firstname, String lastname, String email, String telephone, String password,
            String subscribe)

    {

        elementutil.dosendkeys(this.firstname, firstname);
        elementutil.dosendkeys(this.lastname, lastname);
        elementutil.dosendkeys(this.email, email);
        elementutil.dosendkeys(this.telephone, telephone);
        elementutil.dosendkeys(this.password, password);
        elementutil.dosendkeys(confirmpwd, password);
        if (subscribe.equalsIgnoreCase("Yes")) {

            elementutil.doClick(subscribeYes);
        } else
            elementutil.doClick(subscribeNo);

        elementutil.doClick(agreePolicy);
        elementutil.doClick(submitBtn);
        String actualmsg=elementutil.getelement(regSuccessMsg).getText();
        if(actualmsg.equals(Constants.REGISTRATION_SUCCESS_MSG))
        {
            elementutil.doClick(logoutLink);
            elementutil.doClick(registrationLink);
            
            return true;
            
        }
        else
            return false;
            
        
 
        

    }

}
