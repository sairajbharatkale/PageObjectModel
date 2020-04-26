package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ExcelUtils;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	TestUtil tu;
	ContactsPage cp;
	static String sheetName = "Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		tu = new TestUtil();
		tu.switchToFrame();
		cp = hp.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabel()
	{
		boolean verifyLabel = cp.verifyContactsLabel();
		
		Assert.assertTrue(verifyLabel,"Contacts label is missing on Page");
	}
	
	@Test(priority = 2)
	public void selectContactTest()
	{
		boolean isContactSelected = cp.selectContactByName("Tom Peter");
		
		Assert.assertTrue(isContactSelected, "Failed to select the desired contact ceckbox");
	}
	
	@DataProvider
	public static Object[][] getTestData()
	{
		Object[][] data = ExcelUtils.testData((System.getProperty("user.dir") + "/src/main/java/com/crm/qa/testData/FreeCRMTestData.xlsx"), sheetName);
		
		return data;
		
	}
	
	@Test(priority = 3, dataProvider = "getTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company)
	{
		hp.clickOnNewContactLink();
		cp.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	


}
