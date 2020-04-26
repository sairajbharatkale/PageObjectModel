package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	
	
	  public LoginPageTest() 
	  { 
		  super(); 
		  
	  }
	 
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
	    lp = new LoginPage();
    
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title = lp.loginPageTitle();
		
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void crmLogoImageTest()
	{
		boolean isDisplayed = lp.validateFreeCRMLogo();
		
		Assert.assertTrue(isDisplayed);
	}
	
	@Test(priority = 3)
	public void loginTest() throws InterruptedException 
	{
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
