package com.qa.opencart.test;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.utils.Constants;

public class ProductInfoPageTest extends BaseTest {
	
	//private Object ProductName;

	@BeforeClass
	public void accountPageSetUP() {
		accountPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
//	
//	@Test
//	public void productInfoPage() {
//		searchResult=accountPage.doSearch("MacBook");
//		searchResult.selectProduct("MacBook Pro");	
//		Assert.assertEquals(productInfoPage.getProductTextHeader(), "MacBook Pro");
	//}

	
//	@Test
//	public void productImagesTest() {
//		searchResult = accountPage.doSearch("iMac");
//		productInfoPage = searchResult.selectProduct("iMac");
//		Assert.assertEquals(productInfoPage.productImageCount(), Constants.IMAC_IMAGE_COUNT);
//	}
	
	@Test
	public void productInfoTest() {
		searchResult = accountPage.doSearch("Macbook");
		productInfoPage = searchResult.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = productInfoPage.getProductInfo();
		actProductInfoMap.forEach((k,v) -> System.out.println(k + ":"+ v));
		
		softAssert.assertEquals(actProductInfoMap.get("productName"), "MacBook Pro");
		softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProductInfoMap.get("price"), "$2,000.00");

		softAssert.assertAll();
	}
}
