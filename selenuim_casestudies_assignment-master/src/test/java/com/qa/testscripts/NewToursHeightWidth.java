package com.qa.testscripts;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.NewTourPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewToursHeightWidth {
	WebDriver Driver;
	NewTourPages NewTourOR;
	
	@BeforeTest
	@Parameters({"Browser","Url"})
	public void setUp(String Browser, String Url) throws IOException {

		//String Browser =prop.getProperty("browser");
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
		
		Driver.manage().window().maximize();
		NewTourOR = new NewTourPages(Driver);
		Driver.get(Url);
	}
	
	@AfterTest
	public void tearDown() {
		Driver.quit();
	}
	
	@Test
	public void CheckTextboxHeightWidth() {
		
		
		 int HeightUserName = NewTourOR.getUnameTextFieldHeight();
		 int WidthUserName = NewTourOR.getUnameTextFieldWidth();
		 int HeightPassword = NewTourOR.getPwdTextFieldHeight();
		 int WidthPassword = NewTourOR.getPwdTextFieldWidth();   

         if((HeightUserName==HeightPassword)&&(WidthUserName==WidthPassword)) {
        	 Reporter.log(HeightUserName+"and"+HeightPassword +"are Height of Username & Password text box",true);
        	 Reporter.log(WidthUserName+"and"+WidthPassword +"are Width of Username & Password text box",true);
        	 Reporter.log("Height & Width of Username & Password text box is same",true);
         }
	        
	}
}
