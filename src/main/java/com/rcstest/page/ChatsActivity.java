package com.rcstest.page;

import java.util.concurrent.TimeUnit;

import com.rcstest.element.ChatsActivityElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChatsActivity extends BaseActivity{
	
	/**
	 * 
	 * Class in com.rcs.modules function: Manage elements in corresponding Activity.
	 * 
	 * ChatsActivity(MainActivity) is a class for managing MainActivity elements and method.
	 * 
	 * @author Yanxi
	 * @version 1.0
	 * 
	 *
	 */
	
	Logger logger  =  Logger.getLogger(ChatsActivity.class);
	
	public ChatsActivity(AndroidDriver<WebElement> driver){

		super(driver);
		
	}
	
	
	//Use Page Object Model to locate element.

	@AndroidFindBy(id = ChatsActivityElement.check_img)
	public WebElement check_img;

	@AndroidFindBy(id = ChatsActivityElement.compose_btn)
	public WebElement compose_btn; //when no conversation items in Chats Activity

	@AndroidFindBy(id = ChatsActivityElement.search_btn)
	public WebElement search_btn;

	@AndroidFindBy(id = ChatsActivityElement.title)
	public WebElement title;

	@AndroidFindBy(id = ChatsActivityElement.add_group_conversation)
	public WebElement add_group_conversation;

	@AndroidFindBy(id = ChatsActivityElement.add_conversation)
	public WebElement add_conversation;

	@AndroidFindBy(id = ChatsActivityElement.conversation_search_back)
	public WebElement conversation_search_back;


	//Method
	public void clickSearch() throws InterruptedException{
		search_btn.click();
		logger.info("Click search button.");
		Thread.sleep(1000);
	}

	public void clicktoAddGroup() throws InterruptedException{
		add_group_conversation.click();
		logger.info("Click to add group members.");
		Thread.sleep(1000);
	}

	public void clicktoAddConversation() throws InterruptedException{
		add_conversation.click();
		logger.info("Click to select one.");
		Thread.sleep(1000);
	}

	//need add some action
	public void checkComposeBtn(AndroidDriver<WebElement> driver){
		WebElement compose_btn = null;
		try{
			compose_btn = driver.findElementById(ChatsActivityElement.getCompose_btn());
			compose_btn.click();
			logger.info("Find Coompose button, jump to Select Contact Activity.");
		}catch(Exception e){
			logger.info("Cant't find Coompose button. Already has conversation items.");
		}
	}



		

}
