package com.qa.democart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

    public WebDriver driver;

    public ElementUtil(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement getelement(By Locator)

    {

        return driver.findElement(Locator);

    }

    public List<WebElement> getelements(By Locator)

    {

        return driver.findElements(Locator);

    }

    public void dosendkeys(By Locator, String value)

    {
        getelement(Locator).clear();
        getelement(Locator).sendKeys(value);

    }

    public void doClick(By Locator)

    {

        getelement(Locator).click();
    }

    public boolean doIsDisplayed(By Locator)

    {

        return getelement(Locator).isDisplayed();
    }

    public void clickOnElement(By Locator, String value) {

        List<WebElement> list = getelements(Locator);
        System.out.println("total links" + list.size());
        for (WebElement e : list)

        {
            if (e.getText().equals(value))

                e.click();

        }

    }

    public String doGetText(By Locator)

    {

        return getelement(Locator).getText();

    }

    public List<String> GetListOfLinks(By Locator) {
        List<String> linktext = new ArrayList<String>();

        List<WebElement> linklist = getelements(Locator);

        System.out.println("Total links are " + linklist.size());

        for (WebElement e : linklist) {

            String text = e.getText();
            if (!text.isEmpty()) {
                linktext.add(text);

            }

        }

        return linktext;

    }

    public void doSelectByVisibleText(By Locator, String value)

    {

        Select select = new Select(getelement(Locator));
        select.selectByVisibleText(value);

    }

    public void doSelectByIndex(By Locator, int index)

    {

        Select select = new Select(getelement(Locator));
        select.selectByIndex(index);

    }

    public void doSelectByValue(By Locator, String value)

    {

        Select select = new Select(getelement(Locator));
        select.selectByValue(value);

    }

    public List<String> doDropdownGetOptions(By Locator)

    {
        List<String> optionvallist = new ArrayList<String>();

        Select select = new Select(getelement(Locator));

        List<WebElement> options = select.getOptions();

        for (WebElement e : options)

        {
            String text = e.getText();

            optionvallist.add(text);

        }

        return optionvallist;
    }

    public void doSelectByValue1(By Locator, String value)

    {

        Select select = new Select(getelement(Locator));

        List<WebElement> options = select.getOptions();

        for (WebElement e : options)

        {
            String text = e.getText();

            if (text.equals(value))

            {

                e.click();

            }

        }

    }

    public void doDropdownSelect(By Locator, String value)

    {

        List<WebElement> list = getelements(Locator);

        for (WebElement e : list)

        {

            String text = e.getText();

            if (text.equals(value)) {
                System.out.println("inside if");
                e.click();
                break;

            }

            else
                System.out.println("value not present");

        }

    }

    public By getByLocator(String locatortype, String locatorvalue)

    {
        By locator = null;
        switch (locatortype) {

        case "id":
            locator = By.id(locatorvalue);
            break;

        case "name":
            locator = By.name(locatorvalue);
            break;
        case "className":
            locator = By.className(locatorvalue);
            break;
        case "linkText":
            locator = By.linkText(locatorvalue);
            break;
        case "partialLinkText":
            locator = By.partialLinkText(locatorvalue);
            break;
        case "tagName":
            locator = By.tagName(locatorvalue);
            break;
        case "xPath":
            locator = By.xpath(locatorvalue);
            break;
        case "cssSelector":
            locator = By.cssSelector(locatorvalue);
            break;

        default:
            System.out.println("Please provide the correct locator type " + locatortype);

        }

        return locator;

    }

    public WebElement waitForElementPresence(By locator, int time)

    {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public Alert waitForAlertPresence(int time)

    {

        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.alertIsPresent());

    }

    public String getAlertText(int time) {

        String text = waitForAlertPresence(time).getText().toString();
        acceptAlert(time);
        return text;

    }

    public void acceptAlert(int time) {

        waitForAlertPresence(time).accept();

    }

    public void dismissAlert(int time) {

        waitForAlertPresence(time).accept();

    }

    public void sendKeysInAlert(int time, String value)

    {

        waitForAlertPresence(time).sendKeys(value);

    }

    public String waitForTitleContains(String titlevalue, int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        if (wait.until(ExpectedConditions.titleContains(titlevalue))) {

            return driver.getTitle();

        } else
            return null;

    }

    public String waitForTitleIs(String titlevalue, int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        if (wait.until(ExpectedConditions.titleIs(titlevalue))) {

            return driver.getTitle();

        } else
            return null;

    }

    public void waitForElementToBeClickable(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitForVisibilityOfElement(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        

    }

    public String waitForVisibilityOfElementandGetText(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        

    }
}
