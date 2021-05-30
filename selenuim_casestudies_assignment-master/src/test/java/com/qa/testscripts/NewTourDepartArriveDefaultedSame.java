package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.NewTourPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTourDepartArriveDefaultedSame {
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
	
	@Test(priority=1)
	@Parameters({"UserName","Password"})
	public void Login(String UserName, String Password) throws InterruptedException {
		
		NewTourOR.setUnameTextFieldInput(UserName);
		NewTourOR.setPwdTextFieldInput(Password);
		NewTourOR.IsClicked();
		Thread.sleep(1000);
		
	        String title = Driver.getTitle();
	        
	        boolean status = title.contains("Login");
	        
	        Assert.assertTrue(status);  
	}
	
	@Test(priority=2)
	public void checkDepartArriveDefaultedSame() {
		NewTourOR.NavigateToFlightBooking();
		String DefaultDepart = NewTourOR.getDepartDefaultValue();
		String DefaultArrive = NewTourOR.getArriveDefaultValue();
		if (DefaultDepart.equalsIgnoreCase(DefaultArrive)){
			System.out.println("Default values selected in the Departing from is same as Arriving In");
		}
		else {
			System.out.println("Default values selected in the Departing from is not same as Arriving In");
		}
	}
}
