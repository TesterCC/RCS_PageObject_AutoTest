package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.CountrycodeActivity;
import com.rcstest.page.HelpActivity;
import com.rcstest.page.LoginActivity;
import com.rcstest.utils.DateTimeUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



//Demo instance
//LoginActivity -> TestLoginActivity
//Scenario:Input account and login.

public class TestLoginActivity {
	
	//need to add <WebElement>
	private AndroidDriver<WebElement> driver;
	private final static Logger logger  =  Logger.getLogger(TestLoginActivity.class);

	

	@Test(groups = {"LoginAty"},priority = 1)
	public void testLoginActivity() throws Exception {
		
		InitialDriver.checkAty("I have read");

		LoginActivity la = new LoginActivity(driver);
		la.PageElementsCheck(driver);

		//take screenshot
		String picDir = "D:\\"+DateTimeUtil.formatedTime("yyyyMMdd")+"_screenshot";
		InitialDriver.takeTakesScreenshot(driver,picDir);

	}

	@Test(groups = {"LoginAty"},priority = 2)
	public void testLoginAtyToHelp() throws Exception{
		logger.info("Prepare jump to Help Activity");
		LoginActivity la = new LoginActivity(driver);
		la.toHelpAty();
		Thread.sleep(1000);

		InitialDriver.takeTakesScreenshot(driver);
		logger.info("Take Help Activity screenshot successfully.");

		//help aty back to login aty
		HelpActivity helpaty = new HelpActivity(driver);
		helpaty.helptoLogin();
		logger.info("Back to Login Activity.");
	}


	@Test(groups = {"LoginAty"},priority = 3)
	public void testLoginAtyToTerms() throws InterruptedException {
		LoginActivity la = new LoginActivity(driver);
		la.toTermsConditions();
		Thread.sleep(1000);
		InitialDriver.takeTakesScreenshot(driver);
		logger.info("Take Terms and Conditions Activity screenshot successfully.");

		la.clickBackBtn();
		logger.info("From Terms & Conditions Activity to Login Activity.");

	}


	@Test(groups = {"LoginAty"},priority = 4)
	public void testChooseCountrycode() throws InterruptedException {
		LoginActivity la = new LoginActivity(driver);
		la.toChooseCountrycode();
		Thread.sleep(1000);
		InitialDriver.takeTakesScreenshot(driver);

		CountrycodeActivity ca = new CountrycodeActivity(driver);
		ca.goBack();
	}

	//可增加勾选checkbox-未填写号码，点击Activiate Service的场景

	@Test(groups = {"LoginAty"},priority = 5)
	public void testToOtp() throws InterruptedException {
		LoginActivity la = new LoginActivity(driver);
		la.inputAccount();
		driver.hideKeyboard(); //attention

		la.clickAcceptCheckbox();
		la.checkActivateBtn();

		la.clicktoLogin();
		Thread.sleep(1000);
		InitialDriver.takeTakesScreenshot(driver);
		
		//for standalone test
		la.clickNo();
		Thread.sleep(1000);

//		la.clickYes();
//		Thread.sleep(3000);
//
//		InitialDriver.checkAty("OTP");
//		la.clickCheckimg();
//		InitialDriver.takeTakesScreenshot(driver);

	}


	
	@BeforeClass
	public void beforeMethod() throws Exception{
		driver = InitialDriver.launchApp();
	}

	@AfterClass
	public void afterMethod() throws Exception{
//		driver.closeApp(); //AppiumDriver method
		InitialDriver.killApp();
	}

}
