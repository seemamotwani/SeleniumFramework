package com.qa.opencart.driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	public OptionManager optionManagers;

	/**
	 * This method is used to initialize browser
	 * 
	 * @param browsername
	 * @return
	 */

	public WebDriver init_driver(Properties prop) {
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		optionManagers=new OptionManager(prop);
		
		switch (browsername.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver = new ChromeDriver(optionManagers.getChromeOption());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Plase pass the right browser : " + browsername);
			break;
		}
driver.get(prop.getProperty("url"));
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
		return driver;
	}
	
	
	/*
	 *This is used to initialize the properties from config file 
	 */

	public Properties init_pop() {
		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream("./src/test/resource/config/config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}
	
	

}
