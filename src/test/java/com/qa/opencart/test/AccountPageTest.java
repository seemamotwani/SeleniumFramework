package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void acctPageSetUp() {
		accountPage=loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
//	
//	@Test
//	public void acctPageTitleTest() {
//		String accountTitle=accountPage.getAccountPageTitle();
//		Assert.assertEquals(accountTitle, Constants.ACCOUNT_PAGE_TITLE);
//
//		
//	}
//	@Test
//	public void accountPageSectionList() {
//		List<String> actualSectionList=accountPage.getAccountSecList();
//		Assert.assertEquals(actualSectionList, Constants.getExpectedAccountSectionList());//compare two list
//		
//	}
//	
//
//	@Test
//	public void logoutLinkTest() {
//		Assert.assertTrue(accountPage.isLogoutlinkExist());
//	}
//
//	@Test
//	public void searchExistTest() {
//		Assert.assertTrue(accountPage.isSearchExist());
//	}
//
//	@Test
//	public void headerTest() {
//		Assert.assertEquals(accountPage.getAccountPageHeader(), Constants.ACCOUNTS_PAGE_HEADER);
//	}
//	
//	@DataProvider
//	public Object[][] productData() {
//		return new Object[][] {
//			{"MacBook"},
//			{"iMac"},
//			{"Apple"}
//		};
//	}
//	
//	@Test(dataProvider = "productData")	
//	public void searchTestResult(String productName) {
//		 searchResult= accountPage.doSearch(productName);
//		 Assert.assertTrue(searchResult.getSearchCount()>0);
//	}
//	
//	
//	
//	@DataProvider
//	public Object[][] productSelectData() {
//		return new Object[][] {
//			{"MacBook", "MacBook Pro"},
//			{"iMac", "iMac"},
//			{"Apple", "Apple Cinema 30\""}
//		};
//	}
//	@Test(dataProvider = "productSelectData")
//	public void selectProductTest(String productName, String mainProductName) {
//		 searchResult = accountPage.doSearch(productName);
//		productInfoPage = searchResult.selectProduct(mainProductName);
//		Assert.assertEquals(productInfoPage.getProductTextHeader(), mainProductName);
//	}
	/**
	 * This is test to check Navigation links(text only) available on Page  with data provider.
	 * Expected Navigation link list is available in Test data excel
	 */
	@DataProvider
	public Object[][] navigationLinkList() {
		return ExcelUtil.getData(Constants.ACCOUNT_NAVIGATION_SHEET_NAME);
	}
	
	@Test(dataProvider = "navigationLinkList")
	public void navigationLinkDisplayTest(String navigationLink) {
		//System.out.println(navigationLink);
		Assert.assertTrue(accountPage.getNavListText(navigationLink));
		
		}
		
	/**
	 * This is test to check Navigation links(text only) available on Page  without dataprovider
	 */
	@Test
	public void compareNavLinkNoDataProvider() {
		List<String> actualNavList=accountPage.getNavList();
		System.out.println(actualNavList.size());
		System.out.println(Constants.getExpecetedNavigationLinkAccountPage().size());
		Assert.assertEquals(actualNavList, Constants.getExpecetedNavigationLinkAccountPage());
		
	}
}


