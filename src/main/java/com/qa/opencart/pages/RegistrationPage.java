package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {
	private WebDriver driver;

	private ElementUtil elementUtil;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By emailID = By.id("input-email");
	private By phoneNumber = By.name("telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By checkBox = By.name("agree");
	private By submitButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By registerText =  By.cssSelector("div#content h1");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	

	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By rightNavigationLink=By.xpath("//a[@class='list-group-item']");
	
	public  RegistrationPage(WebDriver driver) {
		this.driver= driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public boolean isSubmitButtonDisplayed() {
		return elementUtil.doIsDisplayed(submitButton);
		
	}
	
	public boolean registration(String firstname, String lastname, String emailid, String telephone,
			String registerpassword,String subscriber) {
		elementUtil.doSendKeys(this.firstName, firstname);
		elementUtil.doSendKeys(this.lastName, lastname);
		elementUtil.doSendKeys(this.emailID, emailid);
		elementUtil.doSendKeys(this.phoneNumber, telephone);
		elementUtil.doSendKeys(this.password, registerpassword);
	
		elementUtil.doSendKeys(this.confirmPassword, registerpassword);
		elementUtil.doClick(checkBox);
		elementUtil.doClick(submitButton);
		
		String msg=registrationSuccessMessage();
		if (msg.equals(Constants.REGISTRATION_SUCCSESSFUL)){
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
			
		}
		 return false;
	}

	public String registrationSuccessMessage() {
		return elementUtil.isElementVisible(registerText, 5).getText();
		
	}
	
}
