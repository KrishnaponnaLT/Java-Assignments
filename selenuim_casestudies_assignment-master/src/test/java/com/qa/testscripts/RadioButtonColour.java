package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.RadioButtonPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonColour {
	WebDriver Driver;
	RadioButtonPage RadioButtonOR;
    
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
        
        RadioButtonOR = new RadioButtonPage(Driver);
        Driver.get(Url);
        Driver.manage().window().maximize();
        
    }
    
    @AfterClass
    public void tearDown() {
        
        Driver.quit();
    }
    @Test(priority=1)
    public void MondayRadioButtionSelect() {
    	RadioButtonOR.IsSelected();
    }
    
    @Test(priority=2)
    public void Checkboxes() {
    		
    	 List<WebElement> CHECKBOXlist = RadioButtonOR.ColourEnabled();
    
    	    for(WebElement checkbox : CHECKBOXlist) {
    	        	  Reporter.log(checkbox.getText(),true);
    	    }
        }
}
