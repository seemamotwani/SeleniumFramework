package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;



public class LoginPage {
	//By locator
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	private By emailId=(By.id("input-email"));
	private By password=By.id("input-password");
	private By loginBtn=By.xpath("//input[@value='Login']");	
	private By forgotpwdlink=By.linkText("Forgotten Password");
	private By rightItems=By.cssSelector("div.list-group a");
	private By registerLink=By.linkText("Register");
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
		
		
	}
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, 5);
	}
	
	public boolean forgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotpwdlink);
		
	}
	public AccountPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		
		return new AccountPage(driver);
	}
	public RegistrationPage doRegisterClick() {
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
		
	}
}
