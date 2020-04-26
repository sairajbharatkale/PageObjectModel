package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//tr//td[contains(text(),'User: Sairaj Kale')]")
	@CacheLookup           /*it says that it will store this userNameLabel in cache 
	                         in memory.Instead of going to webpage it will pick this webelement 
	                         from cache and will improve the speed of the framework*/
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyUserNameDisplayed()
	{
		boolean isDisplayed = userNameLabel.isDisplayed();
		
		return isDisplayed;
		
	}
	
	public String verifyHomePageTitle()
	{
		String homePageTitle = driver.getTitle();
		
		return homePageTitle;
	}
	
	public ContactsPage clickOnContactsLink() 
	{
		contactsLink.click();
		
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		dealsLink.click();
		
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(contactsLink).build().perform();
		
		newContactLink.click();
		
		
	}

}
