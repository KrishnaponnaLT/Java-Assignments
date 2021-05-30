package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.RediffPages;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RediffCreateAccountAvaliable {
	WebDriver Driver;
    RediffPages RediffOR;
    
    @BeforeClass
    @Parameters({"Browser","Url"})
    public void setUp(String Browser, String Url) {
        
        if(Browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            Driver = new ChromeDriver();
        } else if(Browser.equalsIgnoreCase("firefox")) {
        	 System.setProperty("webdriver.geckodriver.driver","c:\\eclipse\\geckodriver.exe");
       	    Driver = new FirefoxDriver();
        } else if(Browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            Driver = new InternetExplorerDriver();
        } 
        
        RediffOR = new RediffPages(Driver);
        Driver.get(Url);
        Driver.manage().window().maximize();
        
    }
    
    @AfterClass
    public void tearDown() {
        
        Driver.quit();
    }
    @Test(priority = 1)
    public void CheckpresenceofLink() {
    	Reporter.log("Create Account Exists On Rediff: "+RediffOR.GetElementExistsNewRegistrationLink(), true);
    	Reporter.log("Is Create Account link enabled: "+RediffOR.GetEnableNewRegistrationLink(),true);
    	Reporter.log("If Create Account Available get the text :"+RediffOR.GettextNewRegistrationLink(),true);
    }
    
    @Test(priority = 2,dependsOnMethods="CheckpresenceofLink")
    public void CheckRegistrationPage() {
        RediffOR.NewRegistrationLink();
        
        String currentUrl = Driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("register"));
        Reporter.log("The user is on registration page", true);
        
    }
    
}
