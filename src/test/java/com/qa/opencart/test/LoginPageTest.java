package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {
	@Test
	public void loginPageTestTitle() {
		String title=loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
		
	}
@Test
public void forgotPwdLink() {
	Assert.assertTrue(loginPage.forgotPwdLinkExist());
}
@Test
public void loginTest() {
	loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	

	
}
@Test
public RegistrationPage registrationLinkTest() {

	return loginPage.doRegisterClick();
}
}
