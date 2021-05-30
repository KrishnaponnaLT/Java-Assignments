package OrangewithTestng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Listeners(TestNGListeners.class)
public class OrangewithTestng{
	
	
	public static WebDriver oBrowser;
	
	@BeforeSuite
	public void lanuch()
	{
			
		System.setProperty("webdriver.chrome.driver", "Chrome floderpath");
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
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.id(("Subscriber_link")), "Subscribe"));	
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void validateAdminLink()
	{
		boolean strStatus = false;
		JavascriptExecutor js= (JavascriptExecutor) oBrowser;

		WebElement oAdminTab = oBrowser.findElement(By.id("menu_admin_viewAdminModule"));
		//oAdminTab.click();
		js.executeScript("arguments[0].click();", oAdminTab);
		WebDriverWait wait = new WebDriverWait(oBrowser, 60);
		WebElement oUserManagement = oBrowser.findElement(By.id("menu_admin_UserManagement"));
		WebElement oJob = oBrowser.findElement(By.id("menu_admin_Job"));
		WebElement oOrganization = oBrowser.findElement(By.id("menu_admin_Organization"));
		WebElement oQualifications = oBrowser.findElement(By.id("menu_admin_Qualifications"));
		if((oUserManagement.getText().equals("User Management")) && (oJob.getText().equals("Job")) && (oOrganization.getText().equals("Organization")) && (oQualifications.getText().equals("Qualifications")))
		{
			strStatus = true;
		}
		else
		{
			strStatus = false;
			System.out.println("The text are not matching");
		}
	}	
	
	
	@Test(retryAnalyzer = Retry.class)
	public void readDashboard()
	{
		
		boolean strStatus = false;
		/*JavascriptExecutor js= (JavascriptExecutor) oBrowser;
		WebElement oDashboardTab = oBrowser.findElement(By.xpath("//div[@id='mainMenu']//ul[@id='mainMenuFirstLevelUnorderedList']//li//a[@id='menu_dashboard_index']"));
		js.executeScript("arguments[0].click();", oDashboardTab);*/
		JavascriptExecutor js1=(JavascriptExecutor)oBrowser;
		js1.executeScript("var kk=document.getElementsByClassName('firstLevelMenu');var links=kk.getElementsByTagName('li')[8];links.click();");
		
		WebDriverWait wait = new WebDriverWait(oBrowser, 60);
		WebElement oDashboardtext = oBrowser.findElement(By.xpath("//div[@class='head']//following::h1"));
		String strDashBoard = oDashboardtext.getText();
		if(strDashBoard.equals("Dashboard"))
		{
			strStatus = true;
		}
		else
		{
			strStatus = false;
			System.out.println("The text are not matching");
		}
		
		
	}
	public static void getScreenshot()
	{
		try
		{
			TakesScreenshot srcScreen = ((TakesScreenshot)oBrowser);
			File SrcFile = srcScreen.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File ("D:\\_Mine\\WorkSpaceHRM\\Failures\\test.png"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
