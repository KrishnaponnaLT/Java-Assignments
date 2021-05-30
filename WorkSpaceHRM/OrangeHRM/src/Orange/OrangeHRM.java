package Orange;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM {
	public static WebDriver oBrowser;

	public static void main(String[] args) {
		
		
		lanuch();
		naviagetAndtitlePrint();
		xpathForWebObjectsOnHomeScreen();
		cssForWebObjectsOnHomeScreen();
		credntials("Admin","admin123");
		validateAdminLink();
	}

	
	
	//Launching Chrome
	public static void lanuch()
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\_Mine\\_Lav\\Others\\chromedriver.exe");
		oBrowser = new ChromeDriver();
		oBrowser.manage().window().maximize();
	}
	
	
	//Printing title of the application
	public static void naviagetAndtitlePrint()
	{
		oBrowser.navigate().to("https://opensource-demo.orangehrmlive.com/");
		System.out.println("The title of the application is: "+oBrowser.getTitle());
		
	}
	
	//Printing all the links in Main page of the application
	public static void printAllLinksonHomeScreen()
		{
		List<WebElement> links = oBrowser.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while(it.hasNext())
	        {
	        String url = it.next().getAttribute("href");
	        System.out.println(url);
	        }
		}
	
	public static void xpathForWebObjectsOnHomeScreen()
	{
		//Xpath for Input Fields
		WebElement oUsernameXpath = oBrowser.findElement(By.xpath("//span[text()='Username']//parent::div"));
		WebElement oPasswordXpath = oBrowser.findElement(By.xpath("//span[text()='Password']//parent::div"));
		System.out.println("The Xpath for all the Input fields are "+oUsernameXpath.getText()+" and " +oPasswordXpath.getText() +" in login page:");		
		//Xpath for Links
		//Password reset link, OrangeHRM Inc link, Linkdln, Facebook, twitter, Youtube
		WebElement oPasswordResetLink = oBrowser.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
		WebElement oOrangeHRMLink = oBrowser.findElement(By.xpath("//a[contains(text(),'OrangeHRM')]"));
		WebElement oLinkdlnLink = oBrowser.findElement(By.xpath("//*[@alt='LinkedIn OrangeHRM group']"));
		WebElement oFaceBookLink = oBrowser.findElement(By.xpath("//*[@alt='OrangeHRM on Facebook']"));
		WebElement oTwitterLink = oBrowser.findElement(By.xpath("//*[@alt='OrangeHRM on twitter']"));
		WebElement oYoutubeLink = oBrowser.findElement(By.xpath("//*[@alt='OrangeHRM on youtube']"));
		
		System.out.println("The Password reset Link: "+oPasswordResetLink.getText());
		System.out.println("The Orange HRM  reset Link: "+oOrangeHRMLink.getText());
		System.out.println("The Linkdln reset Link: "+oLinkdlnLink.getAttribute("alt"));
		System.out.println("The FaceBook reset Link: "+oFaceBookLink.getAttribute("alt"));
		System.out.println("The Twitter reset Link: "+oTwitterLink.getAttribute("alt"));
		System.out.println("The Youtube reset Link: "+oYoutubeLink.getAttribute("alt"));
	}
	
	public static void cssForWebObjectsOnHomeScreen()
	{
		//CSS
		WebElement oUsernameCSS = oBrowser.findElement(By.cssSelector("input#txtUsername"));
		WebElement oPasswordCSS = oBrowser.findElement(By.cssSelector("input#txtPassword"));
		
		//Password reset link, OrangeHRM Inc link, Linkdln, Facebook, twitter, Youtube
		WebElement oPasswordResetLink = oBrowser.findElement(By.cssSelector("a[href*='PasswordResetCode']"));
		WebElement oOrangeHRMLink = oBrowser.findElement(By.cssSelector("a[href*='orangehrm']"));
		WebElement oLinkdlnLink = oBrowser.findElement(By.cssSelector("a[href*='linkedin']"));
		WebElement oFaceBookLink = oBrowser.findElement(By.cssSelector("a[href*='facebook']"));
		WebElement oTwitterLink = oBrowser.findElement(By.cssSelector("a[href*='twitter']"));
		WebElement oYoutubeLink = oBrowser.findElement(By.cssSelector("a[href*='youtube']"));
				
	}
	
	public static void credntials(String Username, String Password)
	{
		
		try
		{
			JavascriptExecutor js= (JavascriptExecutor) oBrowser;
	        js.executeScript("document.getElementById('txtUsername').value='"+Username+"';");
	        js.executeScript("document.getElementById('txtPassword').value='"+Password+"';");
			WebElement oLoginBtn = oBrowser.findElement(By.cssSelector("input#btnLogin"));
			js.executeScript("arguments[0].click();", oLoginBtn);
			oBrowser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(oBrowser, 60);
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.id(("Subscriber_link")), "Subscribe"));	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean validateAdminLink()
	{
		boolean strStatus = false;
		WebElement oAdminTab = oBrowser.findElement(By.id("menu_admin_viewAdminModule"));
		oAdminTab.click();
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
		
		return strStatus;
		
	}
}