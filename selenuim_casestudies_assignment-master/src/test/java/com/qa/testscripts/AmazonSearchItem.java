package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchItem {
	WebDriver driver;
	AmazonPages AmazonpageOb;
	 @BeforeClass
	    @Parameters({"Browser","Url"})
	    public void setUp(String Browser, String Url) {
	        
	        if(Browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if(Browser.equalsIgnoreCase("firefox")) {
	        	 System.setProperty("webdriver.geckodriver.driver","c:\\eclipse\\geckodriver.exe");
	        	 driver = new FirefoxDriver();
	        } else if(Browser.equalsIgnoreCase("ie")) {
	            WebDriverManager.iedriver().setup();
	            driver = new InternetExplorerDriver();
	        } 
	        
		AmazonpageOb = new AmazonPages(driver);
		driver.get(Url);
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	//@Test(priority=1)
	@Parameters({"Category"})
	public void SelectCategory(String Category) throws InterruptedException {
		//Thread.sleep(1000);
		//AmazonpageOb.SetCategoryList(Category);
	}
	
	@Test(priority=1)
	@Parameters({"ItemName"})
	public void ValidateAmazonTextBox(String ItemName){	
		AmazonpageOb.setSearchInput(ItemName);
	}
	
	@Test(priority=2)
	public void CheckIfPageLoaded() {
		
		AmazonpageOb.ClickOnSearch();
		List <WebElement> Books_Name = AmazonpageOb.GetAllItemName();
		List <WebElement> Books_Price = AmazonpageOb.GetAllItemPrice();
    	System.out.println(Books_Name.size());

    	for(WebElement item: Books_Name) {
    		System.out.println(item.getText());
    	}
    	for(WebElement item: Books_Price) {
    		System.out.println(item.getText());
    	}
	}
}
