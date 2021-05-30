package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	WebDriver driver;

	@FindBy(name="url")
	@CacheLookup
	WebElement CategoryList;
	public void SetCategoryList(String itemname) {
	        
	     Select SelectCategory = new Select(CategoryList);
	        
	     SelectCategory.selectByVisibleText(itemname);
	}

	
    @FindBy(id="twotabsearchtextbox")
    @CacheLookup
    WebElement SearchInput;
       
    public void setSearchInput(String ItemName) {
        SearchInput.clear();
        SearchInput.sendKeys(ItemName);
    }
	
	@FindBy(xpath="//*[@id=\"nav-search-submit-text\"]/input")
	@CacheLookup
	WebElement SearchButton;
	
	public void ClickOnSearch() {
		SearchButton.click();
	}
	
    @FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
    @CacheLookup
    List<WebElement> ItemNames;
    
    public List<WebElement> GetAllItemName() {
        return ItemNames;
    }
    
    @FindBy(className="a-price-whole")
    @CacheLookup
    List<WebElement> ItemPrices;
    
    public List<WebElement> GetAllItemPrice() {
        return ItemPrices;
    }
    
	
	public AmazonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
}
