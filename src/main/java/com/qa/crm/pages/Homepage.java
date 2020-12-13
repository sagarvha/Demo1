package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.testbase;

public class Homepage extends testbase{
	
	@FindBy(xpath="//*[@id='top-header-menu']/div[3]/span[1]")
	WebElement namelable;
	@FindBy(xpath="//*[@id='main-nav']/a[3]/span")
	WebElement contactlink;
	//@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a/button")
	//WebElement newcontactlink;
	
	@FindBy(xpath="//*[@id='main-nav']/a[5]/span")
	WebElement Dealslink;
	@FindBy(xpath="//*[@id='main-nav']/a[6]/span")
	WebElement Tasklink;
	
	public Homepage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyhomepagetitle(){
		return driver.getTitle();
	}
	public boolean verifyusername(){
		return namelable.isDisplayed();
	}
	public contactpage clickcontactlink(){
		contactlink.click();
		return new contactpage();
	}
	/*public void newcontactlink(){
		newcontactlink.click();
	}*/
	public dealspage clickdealslink(){
		Dealslink.click();
		return new dealspage();
	}
	public taskpage clicktasklink(){
		Tasklink.click();
		return new taskpage();
	}




}
