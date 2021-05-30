package OrangewithTestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class OrangeHRMFromThirteen {

public static WebDriver oBrowser;
	
	@BeforeSuite
	public void lanuch()
	{
			
		System.setProperty("webdriver.chrome.driver", "D:\\_Mine\\_Lav\\Others\\chromedriver.exe");
		oBrowser = new ChromeDriver();
		oBrowser.manage().window().maximize();
		oBrowser.navigate().to("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void credntials()
	{
		
		try
		{
			JavascriptExecutor js= (JavascriptExecutor) oBrowser;
	        js.executeScript("document.getElementById('txtUsername').value='Admin';");
	        js.executeScript("document.getElementById('txtPassword').value='admin123';");
			WebElement oLoginBtn = oBrowser.findElement(By.cssSelector("input#btnLogin"));
			js.executeScript("arguments[0].click();", oLoginBtn);
			oBrowser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(oBrowser, 60);
			//wait.until(ExpectedConditions.textToBePresentInElementValue(By.id(("Subscriber_link")), "Subscribe"));	
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public static void PIMModule()
	{
		try
		{
			JavascriptExecutor js= (JavascriptExecutor) oBrowser;
			WebElement oPIMModuleBtn=oBrowser.findElement(By.id("menu_pim_viewPimModule"));
			
			js.executeScript("arguments[0].click();", oPIMModuleBtn);
			WebDriverWait wait = new WebDriverWait(oBrowser, 60);
			WebElement oEmplSearch = oBrowser.findElement(By.cssSelector("input#empsearch_employee_name_empName"));
			oEmplSearch.sendKeys("Linda Anderson");
			WebElement oSearchbtn = oBrowser.findElement(By.cssSelector("input#searchBtn"));
			oSearchbtn.click();
			wait.wait(2000);
			WebElement oSearchName1 = oBrowser.findElement(By.xpath("//table[@id='resultTable']//tbody//tr//td[3]//a"));
			String StrFirst = oSearchName1.getText();
			WebElement oSearchName2 = oBrowser.findElement(By.xpath("//table[@id='resultTable']//tbody//tr//td[4]//a"));
			String StrLast = oSearchName2.getText();
			String strFullName = StrFirst+StrLast;
			System.out.println(strFullName);
			OrangewithTestng.getScreenshot();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	
	public static void ScreenModuleXpathNCSS()
	{
		
		//CSS
		WebElement oPIMModul=oBrowser.findElement(By.cssSelector("a#menu_pim_viewPimModule"));
		WebElement oTimeModul=oBrowser.findElement(By.cssSelector("a#menu_time_viewTimeModule"));
		WebElement oMaintainceModul=oBrowser.findElement(By.cssSelector("a#menu_maintenance_purgeEmployee"));
		WebElement oAssignLeave=oBrowser.findElement(By.cssSelector("span.quickLinkText"));
		
		
		//xpath
		WebElement oMarketPlace=oBrowser.findElement(By.xpath("//input[@id='MP_link' and @value='Marketplace']"));
		WebElement oUserButton=oBrowser.findElement(By.xpath("//a[@id='welcome' and contains(text(),'Welcome')]"));
		WebElement oAdminMenu = oBrowser.findElement(By.xpath("//div[@id='mainMenu']//ul//li//a//b[text()='Admin']"));
		WebElement oLeaveListBtn = oBrowser.findElement(By.xpath("//span[@class='quickLinkText' and contains(text(),'Leave List')]"));
		
		
		
	}
	

}
