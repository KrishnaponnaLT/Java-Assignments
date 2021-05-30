package com.qa.testscripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.RediffPages;

public class RediffWorkingWithMultipleWindows {
	  WebDriver Driver;
	    RediffPages RediffOR;
	    
	    @BeforeTest
	    public void setUp() {
	        
	    	System.setProperty("webdriver.geckodriver.driver","c:\\eclipse\\geckodriver.exe");
	    	Driver = new FirefoxDriver(); // 1st windows --> parent window
	        RediffOR = new RediffPages(Driver);
	        
	        Driver.get("https://www.rediff.com/");      
	    }
	    
	    @AfterTest
	    public void tearDown() {
	        
	        Driver.quit();
	        
	    }
	    
	    @Test
	    public void multipleWindows() throws InterruptedException {
	        
	    	  RediffOR.setNewRegistrationLinkClick();
	          
	          RediffOR.setPrivacyPoliciyLinkClick(); // 2nd window opened
	          
	          RediffOR.setTandCLinkClick(); // 3rd window opened
	          
	          Set<String> WinID = Driver.getWindowHandles();
	          
	          
	          Iterator<String> iter = WinID.iterator();
	          
	          while(iter.hasNext()) {
	              System.out.println("******");
	              String next = iter.next();
	              WebDriver window = Driver.switchTo().window(next);
	              String title = window.getTitle();
	              List<WebElement> findElements = window.findElements(By.tagName("a"));
	              System.out.println("Total no. of elements on:" + title + " are:" + findElements.size());
                  Thread.sleep(1000);
	              for(WebElement e:findElements) {
	              System.out.println(e.getText());

	              }
	              System.out.println("--------");

	              }
	          
	          
	      }
	      
}
