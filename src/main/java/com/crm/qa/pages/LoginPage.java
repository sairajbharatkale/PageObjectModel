package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//PageFactory or Object Repository
	
	@FindBy(name = "username")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[text() = 'Sign Up']")
	WebElement signUp;
	
	@FindBy(xpath = "//img[@src = 'https://classic.freecrm.com/img/logo@2x.png']")
	WebElement freeCrmImg;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions Present on Login page
	
	public String loginPageTitle()
	{
		String title = driver.getTitle();
		
		return title;
	}
	
	public boolean validateFreeCRMLogo()
	{
		boolean isGettingDisplayed = freeCrmImg.isDisplayed();
		
		return isGettingDisplayed;
		
	}
	
	public HomePage login(String UserName, String Password) 
	{
		userName.sendKeys(UserName);
		
		password.sendKeys(Password);
		
		//Actions action = new Actions(driver);
		
		//action.moveToElement(loginBtn).click().build().perform();
		
		//loginBtn.click();
		
		//WebElement element = driver.findElement(By.id("gbqfd"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", loginBtn);
		
		
		
		return new HomePage();
	}

}
