package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.qa.util.WebEventListner;
import com.qa.crm.util.Testutil;
import com.qa.crm.util.webEventListner;

public class testbase {
	public static WebDriver driver;
	public static Properties prop;
	public static webEventListner eventlistner;
	public static EventFiringWebDriver edriver;

	public testbase(){
		try{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\admin\\workspace\\pombyenaveen1\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	public static void Initilisation(){
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"));{
		System.setProperty("webdriver.chrome.driver", "C:\\New Driver\\chromedriver.exe");
		driver=new ChromeDriver();
	} 
		/*if (browsername.equals("Firefox")){
		System.setProperty("webdriver.gecko.driver", "C:\\New Driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	}*/
		edriver = new EventFiringWebDriver(driver);
		eventlistner = new webEventListner();
		edriver.register(eventlistner);
		driver = edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		

}
	}



