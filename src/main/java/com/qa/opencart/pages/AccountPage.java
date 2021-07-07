package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By header = By.cssSelector("div#logo h1");
	private By accountSections = By.cssSelector("div#content h2");
	private By searchField = By.name("search");
	private By searchButton = By.xpath("//div[@id='search']//button[@type='button']");
	private By logoutLink = By.linkText("Logout");
	private By navigationLinks=By.cssSelector("a.list-group-item");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	public String getAccountPageTitle() {
		return elementUtil.waitForTitleIs(Constants.ACCOUNT_PAGE_TITLE, 5);

	}

	public String getAccountPageHeader() {
		return elementUtil.doGetText(header);

	}

	public boolean isLogoutlinkExist() {
		return elementUtil.doIsDisplayed(logoutLink);
		
	}
	public void clickLogOut() {
		if (isLogoutlinkExist()) {
		elementUtil.doClick(logoutLink);}
		
		
	}
	public void getAccountSectionLink() {
		
	}
	public List<WebElement> search() {
		return elementUtil.waitForElementsToBeVisible(accountSections, 5);
	}
	
	public List<String> getAccountSecList() {
		List<WebElement> accSecList = elementUtil.waitForElementsToBeVisible(accountSections, 5);
		List<String> accSecValList = new ArrayList<String>();
		for (WebElement e : accSecList) {
			accSecValList.add(e.getText());
		}
		return accSecValList;
	}

	public boolean isSearchExist() {
		return elementUtil.doIsDisplayed(searchField);
	}
	
	public SearchResultsPage doSearch(String productName) {
		System.out.println("searching the product: " + productName);
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchButton);
		return new SearchResultsPage(driver);
	}
	
	
	public List<String> getNavList() {
		List <WebElement> navLinksList=elementUtil.doGetElements(navigationLinks);
		List<String> accNavValList = new ArrayList<String>();
		System.out.println(navLinksList.size());
		for (WebElement e : navLinksList) {
			accNavValList.add(e.getText());
		}
		System.out.println(accNavValList);
		return accNavValList;
		
	}
	
	public boolean getNavListText(String navigationLink) {
		List <WebElement> navLinks=elementUtil.doGetElements(navigationLinks);
		
		for (WebElement e:navLinks) {
			
			String text=e.getText();
			System.out.println(text);
			if(text.equals(navigationLink))
				return true;
		}
		return false;
		
		//return navLinkText;
	}
	
}