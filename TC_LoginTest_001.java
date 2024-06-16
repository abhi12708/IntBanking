package com.initbanking.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.initbanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() 
	{
		
		//driver.get(baseURL);
		//logger.info("URL is opened");
		
		//create a object of loging page to call the method
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered User Name");
		
		lp.setPassword(password);
		logger.info("Password Entered");
		
		lp.clickSubmit();
		logger.info("Submit button is Click able");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("logging Successfully");
		}
		else
		{
			Assert.assertFalse(false);
			logger.info("Loging Fail");
		}
	}
	
}
