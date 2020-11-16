package com.flipkart.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver init_driver(String browserName) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			if (prop.getProperty("headless").equals("yes")) {
				//headless mode
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
			else {
				driver = new ChromeDriver();
			}
		}
		return driver;
	}

	public Properties init_properties()   {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("D:\\Programming Workspace\\SeleniumWorkSpace\\KeywordDriven_Flipkat\\"
					+ "src\\main\\java\\com\\flipkart\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
				//if file not found	
			e.printStackTrace();
		}

		catch (IOException e) {
			// if file not found
			e.printStackTrace();
		}
		return prop;
	}



}
