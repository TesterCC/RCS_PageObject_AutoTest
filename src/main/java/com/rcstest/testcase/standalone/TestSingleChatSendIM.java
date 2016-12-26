package com.rcstest.testcase.standalone;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.ChatsActivity;
import com.rcstest.page.SelectContactActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestSingleChatSendIM {

	//need to add <WebElement>
	private AndroidDriver<WebElement> driver;

	private static final Logger logger = Logger.getLogger(TestSingleChatSendIM.class);


	@Test(groups = {"SingleChat"},priority = 1)
	public void jumpToSingleChat() throws Exception {

		ChatsActivity chatsaty= new ChatsActivity(driver);
		chatsaty.clicktoAddConversation();
		SelectContactActivity selectcontactaty = new SelectContactActivity(driver);
		selectcontactaty.searchContacts("88880013");
		selectcontactaty.clickSearchResult();
		Thread.sleep(2000);  //now enter single chat box
		InitialDriver.takeTakesScreenshot(driver);
  }

	@Test(groups = {"SingleChat"},priority = 2)
	public void sendTextMessage() throws Exception {

		ChatsActivity chatsaty= new ChatsActivity(driver);

		InitialDriver.takeTakesScreenshot(driver);
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