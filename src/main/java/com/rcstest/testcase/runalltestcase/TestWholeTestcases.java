package com.rcstest.testcase.runalltestcase;

import com.rcstest.driver.InitialDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * 
 * Class in com.rcs.testcases is for running all testcases.
 * Add each activity test (different testXXXX ) in the Class.
 * 
 *@author Yanxi
 *@version 1.0 
 * 
 * */

public class TestWholeTestcases {

	private static final Logger logger = Logger.getLogger(TestWholeTestcases.class);

	//need to add <WebElement>
	private AndroidDriver<WebElement> driver;

	//Execute testcases template
	@Test(priority=1)
	public void testAlltestcases() throws Exception {
//write all in here (don't recommand)
	}
	
	@Test(priority=2)
	public void testChatsActivity() throws Exception {

  }


	@Test(priority=3)
	public void testCallsActivity() throws Exception {

	}

	@Test(priority=4)
	public void testContactsActivity() throws Exception {

	}

	@Test(priority=4)
	public void testMoreActivity() throws Exception {
	}

	
	//setup and teardown
	@BeforeClass
	public void beforeMethod() throws Exception{
		driver = InitialDriver.launchApp();
	}

	@AfterClass
	public void afterMethod() throws Exception{
		InitialDriver.killApp();
	}

  
}