package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffPages {
WebDriver Driver;
    
    /*1. Get the locator and store it in the reference variable
    2. Define the actions that to be performed on the elements*/
    
    /*Syntax:
        
        @FindBy(locator="value1")
        @CacheLookup
        WebElement ReferenceName;*/
    
    // Create account link

    @FindBy(xpath="/html/body/div[7]/a[1]")
    @CacheLookup
    WebElement HomePage;
    
    public String getHomePageLogo() {
    	return HomePage.getText();
    }
    
    
    @FindBy(linkText="Create Account")
    @CacheLookup
    WebElement NewRegistrationLink;
    
	public void NewRegistrationLink() {
		NewRegistrationLink.click();
	}
    
    public String getNewRegistrationLink() {
        return NewRegistrationLink.getAttribute("href");
    }
    
    public String GettextNewRegistrationLink() {
		return NewRegistrationLink.getText();
	}
	public boolean GetEnableNewRegistrationLink() {
		return NewRegistrationLink.isEnabled();
	}
	public boolean GetElementExistsNewRegistrationLink() {
		return NewRegistrationLink.isDisplayed();
		
	}
    
    @FindBy(name="proceed")
    WebElement SigInButton;
    
    public void setSigInButtonClick() {
        SigInButton.click();
    }

    public boolean getSigInButtonEnabled() {
        return SigInButton.isEnabled();
    }

    public void setNewRegistrationLinkClick() {
        NewRegistrationLink.click();
    }
    
    @FindBy(linkText="privacy policy")
    WebElement PrivacyPoliciyLink;
    
    public void setPrivacyPoliciyLinkClick() {
        PrivacyPoliciyLink.click();
    }
    
    @FindBy(linkText="terms and conditions")
    WebElement TandCLink;
    public void setTandCLinkClick(){
    	TandCLink.click();
    }
    
    
    @FindBy(id="login1")
    @CacheLookup
    WebElement UnameTextField;
    
    public void setUnameTextFieldInput(String Username) {
        UnameTextField.sendKeys(Username);
    }
    
    public boolean getUnameTextFieldDisplayed() {
        return UnameTextField.isDisplayed();
    }
    
    @FindBy(id="password")
    @CacheLookup
    WebElement PwdTextField;
    
    public void setPwdTextFieldInput(String Password) {
        PwdTextField.sendKeys(Password);
    }
    
    public boolean getPwdTextFieldDisplayed() {
        return UnameTextField.isDisplayed();
    }
    
    
    @FindBy(id="remember")
    @CacheLookup
    WebElement StaySignedIn;
    
    public void setStaySignedInClick() {
        StaySignedIn.click();
    }
    
    public boolean getStaySignedInSelected() {
        return StaySignedIn.isSelected();
    }
    
    
    @FindBy(linkText="Sign in")
    WebElement SiginLink;
    
    public boolean getSiginLinkDisplayed() {
        return SiginLink.isDisplayed();
    }
    
    
    public void setSiginLinkClick() {
        SiginLink.click();
    }
    
    @FindBy(linkText="terms and conditions")
    WebElement TermandConditionsLink;
    
    public void setTermandConditionsLink() {
        TermandConditionsLink.click();
    }

    
    
    @FindAll(@FindBy(tagName="a"))
    List<WebElement> Alllinks;
    
    public List<WebElement> getAlllinks() {
        
        return Alllinks;
        
    }

    public RediffPages(WebDriver Driver) {
        this.Driver = Driver;
        PageFactory.initElements(Driver, this);
    }

    
    
}
