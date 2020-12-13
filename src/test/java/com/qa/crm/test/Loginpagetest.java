 package com.qa.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.testbase;
import com.qa.crm.pages.Homepage;
import com.qa.crm.pages.loginpage;

public class Loginpagetest extends testbase{
	loginpage LOGINPAGE;
	Homepage HOMEPAGE;
	public Loginpagetest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		Initilisation();
		LOGINPAGE=new loginpage();
	}
	@Test(priority=1)
	public void Loginpagetitletest(){
		String title=LOGINPAGE.validatepagetitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		
	}
	@Test(priority=2)
	public void crmlogoimagetest(){
		boolean flag=LOGINPAGE.validateimage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void logingtest(){
		HOMEPAGE=LOGINPAGE.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown(){
		//driver.quit();
	}
	

}
