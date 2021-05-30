package com.qa.stepdefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pages.OrangePages;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeTC16and17and18_StepDefination {
	
	OrangePages  OrangeOR;
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.out.println("I am @Before Method");
	}
	
	@After
	public void tearDown() {
		System.out.println("I am @After Method");
	}
	
	@Given("^the user opens the browser$")
	public void the_user_opens_the_browser() {
		System.setProperty("webdriver.geckodriver.driver","c:\\eclipse\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		OrangeOR = new OrangePages(driver);
	}

	@Then("^the user runs the URL$")
	public void the_user_runs_the_URL() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Given("^I am on OrangeHRP Application$")
	public void i_am_on_OrangeHRP_Application() {
		String title = driver.getTitle();
		System.out.println(title);
		boolean status = title.contains("Orange");
		Assert.assertTrue(status);
		System.out.println("The user is an orangehrm home page");
	}

	@Then("^Login to Application$")
	public void login_to_Application() {
		OrangeOR.setUnameTextFieldInput("Admin");
		OrangeOR.setPwdTextFieldInput("admin123");
		OrangeOR.ClickOnSubmitButton();
	}

	@When("^Dashboard page is avaliable$")
	public void dashboard_page_is_avaliable() {
		String Dashboard = OrangeOR.getDashBoardConfirmation();
		System.out.println("User is on"+Dashboard+"Tab");
	}

	@Then("^Click on Admin Menu$")
	public void click_on_Admin_Menu() {
		OrangeOR.ClickOnAdminTab();
		String Admin = OrangeOR.getTextOnAdmin();
		System.out.println("User is on"+Admin+"Tab");
	}

	@Then("^Close the Browser$")
	public void close_the_Browser() {
		driver.close();
	}
	

	@Then("^Click on Job$")
	public void click_on_Job() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewJobTitleList");
//		WebElement JobMenu = driver.findElement(By.xpath("//a[@id='menu_admin_Job']"));
//	    Actions actions = new Actions(driver);
//	    actions.moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(JobMenu))).build().perform();
//	    actions.moveToElement(JobMenu).build().perform();
//		Thread.sleep(3000);
//		OrangeOR.getJobMenu();
//		Thread.sleep(3000);
	}

	@Then("^validate text on Job Title$")
	public void validate_text_on_Job_Title() {
		String JobTitle = driver.findElement(By.xpath("//h1[contains(text(),'Job Titles')]")).getText();
		Assert.assertEquals("Job Titles", JobTitle);
		System.out.println("User is on"+JobTitle+"Menu");
	}

	@Then("^Click on PIM menu$")
	public void click_on_PIM_menu() {
		OrangeOR.ClickOnPIMTab();
		
	}

	@Then("^validate user on PIM Menu$")
	public void validate_user_on_PIM_Menu() {
		String PIM = OrangeOR.getTextOnPIM();
		System.out.println("User is on"+PIM+"Tab");
	}

	@Then("^Click on Time menu$")
	public void click_on_Time_menu() {
		OrangeOR.ClickOnTimeTab();
	}

	@Then("^validate user on Time Menu$")
	public void validate_user_on_Time_Menu() {
		String Time = OrangeOR.getTextOnTime();
		System.out.println("User is on"+Time+"Tab");
	}

}
