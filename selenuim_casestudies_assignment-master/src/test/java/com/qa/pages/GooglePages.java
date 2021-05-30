package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePages {
WebDriver Driver;
    
    
    @FindBy(xpath="/html/body/div[2]/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input")
    @CacheLookup
    WebElement SearchInput;
    
    
    public void setSearchInput(String Input) {
        SearchInput.clear();
        SearchInput.sendKeys(Input);
        
    }
    
    public void setSubmit() {
        SearchInput.submit();          
    }
    
    public boolean getSearchInputDisplayed() {
        return SearchInput.isDisplayed();
    }
    
    
    
    @FindBy(xpath="/html/body/div[2]/div[2]/form/div[2]/div[1]/div[3]/center/input[1]")
    @CacheLookup
    WebElement SearchBtn;
    
    public void setSearchBtnBtn() {
        SearchBtn.click();
    }
    
    
    public String checkTitle() {
        
        return Driver.getTitle();
    }
    
        
    @FindAll(@FindBy(className = "sbtc"))
    @CacheLookup
    List<WebElement> AutoSuggestLinks;
    
    public List<WebElement> getAutoSuggestLinks() {
        
        return AutoSuggestLinks;
    }
    
    
    
    public GooglePages(WebDriver Driver) {
        this.Driver = Driver;
        PageFactory.initElements(Driver, this);
    }
    
}
