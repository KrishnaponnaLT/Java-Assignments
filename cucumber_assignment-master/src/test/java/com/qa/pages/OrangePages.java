package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangePages {
	
	@FindBy(xpath="//input[@id='txtUsername']")
	@CacheLookup
	WebElement UnameTextField;

	public void setUnameTextFieldInput(String Username) {
		UnameTextField.sendKeys(Username);
	}
	
	@FindBy(xpath="//input[@id='txtPassword']")
	@CacheLookup
	WebElement PwdTextField;

	public void setPwdTextFieldInput(String Password) {
		PwdTextField.sendKeys(Password);
	}
	
	@FindBy(xpath="//input[@id='btnLogin']")
	@CacheLookup
	WebElement SubmitButton;
	public void ClickOnSubmitButton() {

		SubmitButton.click();
	}

	@FindBy(xpath="//b[contains(text(),'Dashboard')]")
	@CacheLookup
	WebElement Dashboard;
	public String getDashBoardConfirmation() {
		
		return Dashboard.getText();
	}

	@FindBy(xpath="//b[contains(text(),'Admin')]")
	@CacheLookup
	WebElement Admin;
	public void ClickOnAdminTab() {

		Admin.click();
	}

	public String getTextOnAdmin() {

		return Admin.getText();
	}
	
	@FindBy(xpath="//a[@id='menu_admin_viewJobTitleList']")
	@CacheLookup
	WebElement JobTitle;
	public void getJobMenu() {
		JobTitle.click();
	}
	
	@FindBy(xpath="//b[contains(text(),'PIM')]")
	@CacheLookup
	WebElement PIM;
	public void ClickOnPIMTab() {

		PIM.click();
	}

	public String getTextOnPIM() {

		return PIM.getText();
	}
	
	@FindBy(xpath="//b[contains(text(),'Time')]")
	@CacheLookup
	WebElement Time;
	public void ClickOnTimeTab() {

		Time.click();
	}

	public String getTextOnTime() {

		return Time.getText();
	}
	
	
	WebDriver driver;
	
	public OrangePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
