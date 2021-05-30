package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {
WebDriver Driver;
	
	@FindBy(xpath="//*[@id=\"daysofweek\"]/p[1]/input")
    @CacheLookup
    WebElement Radiobutton;
	
	public void IsSelected() {
		Radiobutton.click();
	}
	
	@FindBy(xpath="//*[@id=\"colors\"]/p")
    @CacheLookup
    List<WebElement> AllColors;
	
	public List<WebElement> ColourEnabled() {
		 return AllColors;
	
	}
	
	public RadioButtonPage(WebDriver Driver) {
		this.Driver = Driver;
        PageFactory.initElements(Driver, this);
	}

}
