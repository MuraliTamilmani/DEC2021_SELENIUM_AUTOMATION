package com.qa.democart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public WebDriver driver;

    public WebDriver initDriver(Properties prop)

    {
        String browsername = prop.getProperty("browser");

        System.out.println("Browsername is :" + browsername);

        if (browsername.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else if (browsername.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        else
            System.out.println("Please pass the correct browsername :" + browsername);

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get(prop.getProperty("url"));

        return driver;

    }

    public Properties initproperties()

    {
        Properties prop = null;

        try {
            FileInputStream fs = new FileInputStream("./src/test/Resources/Config/config.properties");
            prop = new Properties();
            prop.load(fs);
        }

        catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
