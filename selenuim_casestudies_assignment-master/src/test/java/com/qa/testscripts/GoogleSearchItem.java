package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.GooglePages;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchItem {
	 WebDriver Driver;
	 GooglePages GoogleOR;
	    
	    
	    @BeforeMethod
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
	        
	        GoogleOR = new GooglePages(Driver);
	        Driver.manage().window().maximize();
	        Driver.get(Url);       
	        
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	        Driver.quit();
	    }

	    @Test(dataProvider = "getData")
	    // @Parameters({ "Category", "ItemName" }) // read the values from XML file

	    public void SearchItem(String ItemName) throws InterruptedException {

	        GoogleOR.setSearchInput(ItemName); // 2nd input --> Replace the test data with parameter
	        Thread.sleep(3000);
	        System.out.println("Auto Suggest Links are: ");

	        List<WebElement> AutoSuggest_Links = GoogleOR.getAutoSuggestLinks();
	        for (WebElement item : AutoSuggest_Links) {
	        //  System.out.println(item.getText());
	            Reporter.log(item.getText(), true);
	            
	        }

	        GoogleOR.setSubmit();
	        
	        String searchtitle = GoogleOR.checkTitle();
	        if (searchtitle.contains(ItemName)) {
	            //System.out.println(" Title: " + searchtitle + " matches with input string");

	            Reporter.log(searchtitle + " matches with input string", true);
	            
	        } else {
	            Reporter.log(searchtitle + " does not matches with input string", true);

	        }
	        
	        Assert.assertEquals(searchtitle, ItemName);
	        Reporter.log(searchtitle,true);
	        
	        /*SoftAssert SAssert = new SoftAssert();
	        SAssert.assertEquals(searchtitle,ItemName);
	        Reporter.log(searchtitle,true);
	        SAssert.assertAll();*/
	        
	       // String actualtitle = driver.getTitle();
	       // Assert.assertTrue(actualtitle.contains("Testing"));
	        //Reporter.log("The user is on valid Search page", true);


	        // Assert.assertTrue(actualtitle.contains("for Failed"));
	        // Reporter.log("The user is not on valid Search page", true);

	    }

	    @DataProvider // get data method
	    public Object[] getData() {
	        Object[] data = new Object[3];

	        data[0] = "software testing";
	        data[1] = "automation testing";
	        data[2] = "performance testing";

	        return data;

	    }
	    
}
