package com.qa.crm.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.testbase;

public class loginpage extends testbase{
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a/span[2]")
	WebElement signup;
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[1]/div/input")
	WebElement username;
	@FindBy(xpath="//*[@id='ud']/div/div/form/div/div[2]/div/input")
	WebElement password;
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]")
	WebElement login;
	@FindBy(xpath="/html/body/div[1]/main/section[1]/a")
	WebElement signuplogo;
	
	public loginpage(){
		PageFactory.initElements(driver, this);
	}
	//actions
	public String validatepagetitle(){
		return driver.getTitle();
	}
	public boolean validateimage(){
		return signuplogo.isDisplayed();
	}
	public Homepage login(String un ,String pwd){
		signup.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new Homepage();
	}
}
