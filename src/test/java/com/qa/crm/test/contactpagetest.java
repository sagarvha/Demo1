package com.qa.crm.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.testbase;
import com.qa.crm.pages.Homepage;
import com.qa.crm.pages.contactpage;
import com.qa.crm.pages.loginpage;
import com.qa.crm.util.Testutil;

public class contactpagetest extends testbase{
	loginpage LOGINPAGE;
	Homepage HOMEPAGE;
	contactpage CONTACTPAGE;
	Testutil TESTUTIL;
	String sheetName="contact";
	
	public contactpagetest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		Initilisation();
		LOGINPAGE=new loginpage();
		CONTACTPAGE=new contactpage();
		HOMEPAGE=new Homepage();
		
		HOMEPAGE=LOGINPAGE.login(prop.getProperty("username"), prop.getProperty("password"));
		HOMEPAGE.clickcontactlink();
		
	}
	
	@DataProvider
	public Object[][] getcrmdata(){
		Object data [][]=TESTUTIL.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getcrmdata")
		public void ValidatecreatenewData(String firstname,String lastname,String company){
			CONTACTPAGE.newcontactlink();
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a/button")).click();
		String currentURL=driver.getCurrentUrl();
			CONTACTPAGE.CreateNewContact(firstname, lastname, company);
		}
	
	
	@AfterMethod
	public void teardown(){
		//driver.quit();
	}

	
}
