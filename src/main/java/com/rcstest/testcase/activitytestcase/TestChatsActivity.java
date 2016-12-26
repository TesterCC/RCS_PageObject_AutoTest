package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.ChatsActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestChatsActivity{

	//need to add <WebElement>
	private AndroidDriver<WebElement> driver;

	private static final Logger logger = Logger.getLogger(TestChatsActivity.class);


	@Test(groups = {"ChatsAty"},priority = 1)
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
		//testcase need rebuild==================
		
//		InitialDriver.checkAty(chatsaty.title.getText());
//		logger.info("This activity title is :->" + chatsaty.title.getText());
//
//		chatsaty.clickSearch();
//
//		chatsaty.clicktoAddConversation();
//		driver.pressKeyCode(AndroidKeyCode.BACK);
//
//		chatsaty.clicktoAddGroup();
//		driver.pressKeyCode(AndroidKeyCode.BACK);
	  
  }
	
	
	@BeforeTest
	public void beforeMethod() throws Exception{
		driver = InitialDriver.launchApp();
	}

	@AfterTest
	public void afterMethod() throws Exception{
		InitialDriver.killApp();
	}

 
  }