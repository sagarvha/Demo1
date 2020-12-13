package com.qa.crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.qa.base.testbase;

public class Testutil extends testbase{
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\admin\\workspace\\pombyenaveen1\\src\\main\\java\\com\\qa\\crm\\testdata\\freecrmdate.xlsx";
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public void Switchtoframe(){
		driver.switchTo().frame("viewport");
		
	}
	public static Object[][]getTestData(String sheetName){
		FileInputStream file=null;
		try{
			file=new FileInputStream(TESTDATA_SHEET_PATH);
			
			}catch(FileNotFoundException e){
				e.printStackTrace();
				
			}
		try{
			book=WorkbookFactory.create(file);
			
		}/*catch(InvalidFormatException e){
			e.printStackTrace();
		}*/catch(IOException e){
			e.printStackTrace();
			}
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//System.out.println(sheet.getLastRowNum()+"------");
		//sheet.getRow(0).getLastCellNum();
		for(int i=0; i<sheet.getLastRowNum();i++){
		for(int k=0;k<sheet.getRow(0).getLastCellNum(); k++){
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
		return data;
	}
	public static void takeScreenShot() throws IOException{
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir");
		
		Files.copy(file, new File(path+ "screenshot" + System.currentTimeMillis()+ ".jpeg"));

	}

}
