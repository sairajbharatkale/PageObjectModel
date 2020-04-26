package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement surname;
	
	@FindBy(name = "client_lookup")
	WebElement companyName;
	
	@FindBy(xpath = "//form[@name = 'contactForm']//td//input[@type = 'submit' and @value = 'Save']")
	WebElement saveContactButton;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public boolean selectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td//input[@type = 'checkbox']")).click();
		
		boolean contactIsSelected = driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td//input[@type = 'checkbox']")).isSelected();
		
		return contactIsSelected;
	}
	
	public void createNewContact(String title, String first_Name, String surName,String company_Name)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		
		select.selectByVisibleText(title);
		
		firstName.sendKeys(first_Name);
		
		surname.sendKeys(surName);
		
		companyName.sendKeys(company_Name);
		
		saveContactButton.click();
	}

}
