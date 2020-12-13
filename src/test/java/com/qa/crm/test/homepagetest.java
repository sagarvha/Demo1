package com.qa.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.testbase;
import com.qa.crm.pages.Homepage;
import com.qa.crm.pages.contactpage;
import com.qa.crm.pages.dealspage;
import com.qa.crm.pages.loginpage;
import com.qa.crm.pages.taskpage;

public class homepagetest extends testbase{
	loginpage LOGINPAGE;
	Homepage HOMEPAGE;
	contactpage CONTACTPAGE;
	dealspage DEALSPAGE;
	taskpage TASKPAGE;
	
	
	public homepagetest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		Initilisation();
		LOGINPAGE=new loginpage();
		HOMEPAGE=LOGINPAGE.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void verifyhomepagetitletest(){
		String homepagetitle=HOMEPAGE.verifyhomepagetitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM","homepagetitle not matched");
	}
	@Test
	public void verifyusernametest(){
		boolean flag=HOMEPAGE.verifyusername();
		Assert.assertTrue(flag);
	}
	@Test
	public void verifycontacttest(){
		CONTACTPAGE=HOMEPAGE.clickcontactlink();
	}
@Test
public void verifydealspagetest(){
	DEALSPAGE=HOMEPAGE.clickdealslink();
}
@Test
public void verifytaskpagetest(){
	TASKPAGE=HOMEPAGE.clicktasklink();
}
	
	@AfterMethod
	public void teardown(){
		//driver.quit();
	}
}
