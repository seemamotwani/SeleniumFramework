package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	private WebDriver driver;
	ElementUtil elementUtil;

	private By serachResultheader=By.cssSelector("div#content h1");
	private By productResults=By.cssSelector("div.caption a");
	
	
	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		
	}
	

	public int getSearchCount() {
		return elementUtil.waitForElementsToBeVisible(productResults, 5).size();
	}
	
	public ProductInfoPage selectProduct(String mainProductName) {
		System.out.println("main product name is : " + mainProductName);
		List <WebElement> prodList=elementUtil.waitForElementsToBeVisible(productResults, 5);
		for (WebElement e: prodList) {
			String text=e.getText();
			System.out.println(text);
			if (text.equals(mainProductName)) {
				e.click();
				break;
				
			}
		}
	
		return new ProductInfoPage(driver);
	}
	
}
