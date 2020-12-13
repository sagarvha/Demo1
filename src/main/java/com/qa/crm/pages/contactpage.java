package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.testbase;

public class contactpage extends testbase {
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[1]")
	WebElement contactname;
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div/label")
	WebElement clickcheckbox;
	@FindBy(name="first_name")
	WebElement Firstname;
	@FindBy(name="last_name")
	WebElement Lastname;
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement companyname;
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
	WebElement savebtn;
	//@FindBy(xpath="//a[@class='edit icon']")
	WebElement Newcontactlink=driver.findElement(By.linkText("New"));
	//*[@id="dashboard-toolbar"]/div[2]/div/button[2]
	//*[@id="dashboard-toolbar"]/div[2]/div/a/button
	//WebElement Newcontactlink;
	
	public contactpage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontactlable(){
		return contactname.isDisplayed();
	}
	
	public void selectcheck(){//(String name)
		//driver.findElement(By.xpath("//*[@id='"+name+"']/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div/label")).click();
		clickcheckbox.click();
	}
	public void newcontactlink(){
		//driver.get("https://ui.freecrm.com/companies/new");
		Newcontactlink.click();

	}

	
	public void CreateNewContact(String ftName,String LtName,String Comp){
		Firstname.sendKeys(ftName);
		Lastname.sendKeys(LtName);
		companyname.sendKeys(Comp);
		savebtn.click();
	}

}
