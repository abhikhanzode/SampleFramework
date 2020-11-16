package com.flipkart.Engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class KeywordEngine {

	public WebDriver driver;
	public Properties prop;

	public static Workbook book;
	public static Sheet sheet;


	public final String SCENARIO_SHEET_PATH = "D:\\Programming Workspace\\SeleniumWorkSpace"
			+ "\\KeywordDriven_Flipkat\\src\\main\\resources\\com\\flipkart\\scenarios\\data.xlsx";

	public void startExecution(String sheetName) {
		String locatorName = null;
		String locatorValue = null;

		FileInputStream file = null;
		try {
			file = new FileInputStream(SCENARIO_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		int k =0;

		for(int i =0; i<sheet.getLastRowNum(); i++) 
		{
			String locatorColValue = sheet.getRow(i+1).getCell(k+1).toString().trim();	
			if (!locatorColValue.equalsIgnoreCase("NA")) {
				locatorName= locatorColValue.split("=")[0].trim();
				locatorValue =  locatorColValue.split("=")[1].trim();
			}
			String action = sheet.getRow(i+1).getCell(k+2).toString().trim(); // 2nd column
			String value = sheet.getRow(i+1).getCell(k+3).toString().trim();
			
			switch (action) {
			case "open browser":
				
				break;

			default:
				break;
			}

		}

	}

}
