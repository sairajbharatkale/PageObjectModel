package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	TestUtil tu;
	ContactsPage cp;
	
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setup()  
	{
		initialization();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		tu = new TestUtil();
		cp = new ContactsPage();
		
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() 
	{
		
		
		String homePageTitle = hp.verifyHomePageTitle();
		
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{
		tu.switchToFrame();
		
		boolean isUserNameDisplayed = hp.verifyUserNameDisplayed();
		
		Assert.assertTrue(isUserNameDisplayed, "User Name is not getting Displayed");
		
	}
	
	@Test(priority = 3)
	public void verifyContactsLink()
	{
		tu.switchToFrame();
		
		cp = hp.clickOnContactsLink();
	}
	
	
	
	  @AfterMethod public void tearDown()
	  {
	  
	  driver.quit();
	  
	  }
}
