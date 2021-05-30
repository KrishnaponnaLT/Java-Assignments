package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class NewTourBookingFlightTicket {
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
	@Parameters({"Index", "Country", "Month", "Day", "ArriveCountry", "ArriveMonth", "ArriveDay"})
	public void FlightTicketBooking(int Index, String Country, String Month, String Day, String ArriveCountry, String ArriveMonth, String ArriveDay ) {
		
		NewTourOR.NavigateToFlightBooking();
		NewTourOR.SelectByIndexPassengers(Index);
		NewTourOR.SelectBYValueDepartingCountry(Country);
		NewTourOR.SelectBYValueDepartingMonth(Month);
		NewTourOR.SelectBYValueDepartingDay(Day);
		NewTourOR.SelectByVisibleTextArrivingInCountry(ArriveCountry);
		NewTourOR.SelectByVisibleTextArrivingInMonth(ArriveMonth);
		NewTourOR.SelectByVisibleTextArrivingInDay(ArriveDay);
		NewTourOR.ClickToContinue();
	}
	
}
