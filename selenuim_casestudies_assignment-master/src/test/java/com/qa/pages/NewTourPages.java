package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewTourPages {
	
     WebDriver Driver;
     
     @FindBy(name="userName")
     @CacheLookup
     WebElement UnameTextField;
     
     public void setUnameTextFieldInput(String Username) {
         UnameTextField.sendKeys(Username);
     }
     
     public int getUnameTextFieldHeight() {
         return UnameTextField.getSize().getHeight();
     }
     
     public int getUnameTextFieldWidth() {
         return UnameTextField.getSize().getWidth();
     }
     
     public boolean getUnameTextFieldDisplayed() {
         return UnameTextField.isDisplayed();
     }
     
     @FindBy(name="password")
     @CacheLookup
     WebElement PwdTextField;
     
     public void setPwdTextFieldInput(String Password) {
         PwdTextField.sendKeys(Password);
     }
     
     public int getPwdTextFieldHeight() {
         return PwdTextField.getSize().getHeight();
     }
     
     public int getPwdTextFieldWidth() {
         return PwdTextField.getSize().getWidth();
     }
     
     @FindBy(name="submit")
     @CacheLookup
     WebElement SubmitButton;
     
     public void IsClicked() {
    	 SubmitButton.click();
     }
     
     @FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a")
     @CacheLookup
     WebElement FlightBooking;
     
     public void NavigateToFlightBooking() {
    	 FlightBooking.click();
     }
     
     @FindBy(name="passCount")
     @CacheLookup
     WebElement Passengers;
     
     public void SelectByIndexPassengers(int Index) {
    	 Select passCount = new Select(Passengers);
    	 passCount.selectByIndex(Index);
     }
     
     
     
     @FindBy(name="fromPort")
     @CacheLookup
     WebElement DepartingFromCountry;
     
     public void SelectBYValueDepartingCountry(String Country) {
    	 Select depart = new Select(DepartingFromCountry);
    	 depart.selectByValue(Country);
     }
      		 
     @FindBy(name="fromMonth")
     @CacheLookup
     WebElement DepartingFromMonth;
     
     public void SelectBYValueDepartingMonth(String Month) {
    	 Select depart = new Select(DepartingFromMonth);
    	 depart.selectByValue(Month);
     }
     
          
     @FindBy(name="fromDay")
     @CacheLookup
     WebElement DepartingFromDay;
     
     public void SelectBYValueDepartingDay(String Day) {
    	 Select depart = new Select(DepartingFromDay);
    	 depart.selectByValue(Day);
     }    
     
     @FindBy(name="toPort")
     @CacheLookup
     WebElement ArrivingInCountry;
     
     public void SelectByVisibleTextArrivingInCountry(String Country) {
    	 Select arrive = new Select(ArrivingInCountry);
    	 arrive.selectByVisibleText(Country);
     }
      		 
     @FindBy(name="toMonth")
     @CacheLookup
     WebElement ArrivingInMonth;
     
     public void SelectByVisibleTextArrivingInMonth(String Month) {
    	 Select arrive = new Select(ArrivingInMonth);
    	 arrive.selectByVisibleText(Month);
     }
     
          
     @FindBy(name="toDay")
     @CacheLookup
     WebElement ArrivingInDay;
     
     public void SelectByVisibleTextArrivingInDay(String Day) {
    	 Select arrive = new Select(ArrivingInDay);
    	 arrive.selectByVisibleText(Day);
     }    
    
     
     
     @FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input")
     @CacheLookup
     WebElement CountinueButton;
     
     public void ClickToContinue() {
    	 CountinueButton.click();
     }
     
     @FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select")
     @CacheLookup
     WebElement DepartDefault;
     
     public String getDepartDefaultValue() {
    	 
    	 Select select = new Select(DepartDefault);

    	 WebElement option = select.getFirstSelectedOption();

    	 String defaultItem = option.getText();

    	 System.out.println(defaultItem );
		return defaultItem;
     }
     
     @FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select")
     @CacheLookup
     WebElement ArriveDefault;
     
     public String getArriveDefaultValue() {
    	 
    	 Select select = new Select(ArriveDefault);

    	 WebElement option = select.getFirstSelectedOption();

    	 String defaultItem = option.getText();

    	 System.out.println(defaultItem );
		return defaultItem;
     }
     
	public NewTourPages(WebDriver Driver) {
        this.Driver = Driver;
        PageFactory.initElements(Driver, this);
    }
}
