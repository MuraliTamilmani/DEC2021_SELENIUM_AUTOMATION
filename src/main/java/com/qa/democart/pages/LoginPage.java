package com.qa.democart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.ElementUtil;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    // private By locators:
    private By emailaddress = By.id("input-email");
    private By password = By.id("input-password");
    private By loginbtn = By.xpath("//input[@class='btn btn-primary']");
    private By forgotpwdlink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
    private By welcomelogotitle = By.xpath("//div[@id='logo']//a[text()='Your Store']");
    private By links=By.xpath("//div[@class='list-group']/a");
    private By menulinks=By.xpath("//div [@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li");
    private By registrationLink=By.linkText("Register");

    // constructor:
    public LoginPage(WebDriver driver)

    {

        this.driver = driver;
        elementUtil=new ElementUtil(driver);

    }

    // Behavior of the page

    public String loginPageTitle() {
        return driver.getTitle();

    }

    public String getLoginPageHeaderText()

    {
        return driver.findElement(welcomelogotitle).getText();

    }

    public boolean forgotPasswordLinkDisplayed() {

        return driver.findElement(forgotpwdlink).isDisplayed();
    }

    public AccountsPage doLogin(String un, String pwd) {
        driver.findElement(emailaddress).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginbtn).click();
        return new AccountsPage(driver);

    }
    
    public List<String> getLinks()
    {
        
        return elementUtil.GetListOfLinks(links);
    }
    
    public List<String> getMenuLinks()
    {
        
        return elementUtil.GetListOfLinks(menulinks);
    }
    
    public RegistrationPage clickRegisterPage()
    {
        
        elementUtil.doClick(registrationLink);
        return new RegistrationPage(driver);
    }

}