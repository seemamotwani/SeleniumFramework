package com.qa.opencart.test;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {
	@BeforeClass
	public void RegistrationSetup() {

		registrationPage = loginPage.doRegisterClick();

	}

	@DataProvider
	public Object[][] getRegistrationData() {
		//return new Object[][] { { "amees22", "amees98", "amitdasdsdda@gmail.com", "398-660-5976", "dnKnow@12" } };
		return ExcelUtil.getData(Constants.REGISTER_SHEET_NAME);

	}
	public String getRandomEmail() {
		Random randomGenerator=new Random();
		return "tina"+randomGenerator.nextInt(1000)+"@gamil.com";
		
		
	}

	@Test(dataProvider = "getRegistrationData")
	public void registerTest(String firstname, String lastname, String telephone,
			String registerpassword, String subscriber) {

		Assert.assertTrue(registrationPage.registration(firstname, lastname, getRandomEmail(), telephone, registerpassword,subscriber));
		//Assert.assertEquals(registrationPage.registrationSuccessMessage(), Constants.REGISTRATION_SUCCSESSFUL );
		
	}

	
	
}
