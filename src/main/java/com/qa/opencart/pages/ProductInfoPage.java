package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private Map<String, String> productInfoMap;
	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	
	private By qty = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	private By sucessMessg = By.cssSelector("div.alert.alert-success.alert-dismissible");
	

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil =new ElementUtil(driver);
	}

	public String getProductTextHeader() {

		return elementUtil.doGetText(productHeader);

	}

//	public int productImageCount() {
//		return elementUtil.waitForElementsToBeVisible(images, 5).size();
//	}

	public  Map<String, String> getProductInfo() {
		productInfoMap = new LinkedHashMap<String, String>();//linked hashMap is used to maintain order
		productInfoMap.put("productName", getProductTextHeader());
		getPtoductMetaData();
		getProductPricingData();
		return productInfoMap;
	}
	
	
	private void getPtoductMetaData() {
		List<WebElement> ListProductMetadata = elementUtil.doGetElements(productMetaData);
		for (WebElement e : ListProductMetadata) {
			String text = e.getText();
			String meta[] = text.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
	}
	
	private void getProductPricingData() {
		List<WebElement> ListPriceMetadata = elementUtil.doGetElements(productPriceData);
		String price=ListPriceMetadata.get(0).getText().trim();
		String tax=ListPriceMetadata.get(0).getText().trim();
		productInfoMap.put("price", price);
		productInfoMap.put("extax", tax);
	}
	
	
	
}
