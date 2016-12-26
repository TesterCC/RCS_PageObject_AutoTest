package com.rcstest.testcase.runalltestcase;

import com.rcstest.page.CallsActivity;
import com.rcstest.page.ChatsActivity;
import com.rcstest.page.ContactsActivity;
import com.rcstest.page.MoreActivity;
import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import org.testng.annotations.*;

import com.rcstest.driver.InitialDriver;


/**
 * 
 * Class in com.rcs.testcases is for running all testcases.
 * Add each activity test (different testXXXX ) in the Class.
 * 
 *@author Yanxi
 *@version 1.0 
 * 
 * */

public class TestAllTestcases {

	private static final Logger logger = Logger.getLogger(TestAllTestcases.class);

	//need to add <WebElement>
	private AndroidDriver<WebElement> driver;

//	@Test(priority=1)
//	public void testAlltestcases() throws Exception {
//		//If need to test all testcases in a method, not recommand
//
//	}
	
	@Test(priority=2)
	public void testChatsActivity() throws Exception {
		ChatsActivity chatsaty= new ChatsActivity(driver);
		chatsaty.clickSearch();
		Thread.sleep(1000);
		driver.hideKeyboard();
		Thread.sleep(1000);
		chatsaty.conversation_search_back.click();
		Thread.sleep(1000);

		chatsaty.clickCallsMainbtn();
		InitialDriver.takeTakesScreenshot(driver);

		chatsaty.clickContactsMainbtn();
		InitialDriver.takeTakesScreenshot(driver);

		chatsaty.clickMoreMainbtn();
		InitialDriver.takeTakesScreenshot(driver);

		chatsaty.clickChatsMainbtn();

		Thread.sleep(1000);
  }


	@Test(priority=3)
	public void testCallsActivity() throws Exception {
		CallsActivity callsaty = new CallsActivity(driver);
		callsaty.clickCallsMainbtn();
		InitialDriver.checkAty("Calls");
		Thread.sleep(1000);

		callsaty.clicktoDialer();
		Thread.sleep(1000);
		callsaty.clickBackBtn();
		Thread.sleep(1000);

	}

	@Test(priority=3)
	public void testContactsActivity() throws Exception {
		InitialDriver.checkAty("Contacts");

		ContactsActivity contactsaty = new ContactsActivity(driver);
		contactsaty.clickContactsMainbtn();
		contactsaty.clickSearchBtn();
		driver.hideKeyboard();
		contactsaty.clickBackBtn();
		Thread.sleep(1000);

	}

	@Test(priority=4)
	public void testMoreActivity() throws Exception {
		MoreActivity moreaty = new MoreActivity(driver);
		moreaty.clickMoreMainbtn();
		Thread.sleep(1000);
		InitialDriver.checkAty("More");
		Thread.sleep(1000);

		moreaty.clicktoLogout();
		moreaty.getAlertContent();
		moreaty.clickNo();
		Thread.sleep(1000);

	}

	
	
	@BeforeClass
	public void beforeMethod() throws Exception{
		driver = InitialDriver.launchApp();
	}

	@AfterClass
	public void afterMethod() throws Exception{
		InitialDriver.killApp();
	}

  
}