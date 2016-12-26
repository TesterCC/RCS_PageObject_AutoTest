package com.rcstest.page;


import com.rcstest.element.MoreActivityElement;
import com.rcstest.module.PageElementsCheck;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Li Yanxi on 2016/4/5.
 */
public class MoreActivity extends BaseActivity implements PageElementsCheck{

    Logger logger  =  Logger.getLogger(MoreActivity.class);

    public MoreActivity(AndroidDriver<WebElement> driver){
        super(driver);
    }


    //need supplement
    public void PageElementsCheck(AndroidDriver<WebElement> driver) {
        WebElement title = null;
        WebElement profile = null;
        WebElement chatcall_settings = null;
        WebElement contacts_settings = null;
        WebElement tell_a_friend = null;
        WebElement notification = null;
        WebElement logout = null;

        try{
            title = driver.findElementById(MoreActivityElement.getTitle());
            profile = driver.findElementByXPath(MoreActivityElement.getProfile());
            chatcall_settings = driver.findElementByXPath(MoreActivityElement.getChatcall_settings());
            contacts_settings = driver.findElementByXPath(MoreActivityElement.getContacts_settings());
            tell_a_friend = driver.findElementByXPath(MoreActivityElement.getTell_a_friend());
            notification = driver.findElementByXPath(MoreActivityElement.getNotifications());
            logout = driver.findElementByXPath(MoreActivityElement.getLogout());
            logger.info("Find All Elements.");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Can't find Element."+"\n"+e.getMessage());
        }
    }

    @AndroidFindBy(id = MoreActivityElement.title)
    public WebElement title;

    @AndroidFindBy(xpath = MoreActivityElement.profile)
    public WebElement profile;

    @AndroidFindBy(xpath = MoreActivityElement.chatcall_settings)
    public WebElement chatcall_settings;

    @AndroidFindBy(xpath = MoreActivityElement.contacts_settings)
    public WebElement contacts_settings;

    @AndroidFindBy(xpath = MoreActivityElement.tell_a_friend)
    public WebElement tell_a_friend;

    @AndroidFindBy(xpath = MoreActivityElement.notifications)
    public WebElement notifications;

    @AndroidFindBy(xpath = MoreActivityElement.help)
    public WebElement help;

    @AndroidFindBy(xpath = MoreActivityElement.about)
    public WebElement about;

    @AndroidFindBy(xpath = MoreActivityElement.logout)
    public WebElement logout;


    public void clicktoProfileAty(){
        clickElement(profile);
        logger.info("Click Profile Item.");
    }

    public void clicktoChatcallSettingsAty(){
        clickElement(chatcall_settings);
        logger.info("Click Chat & Call Settings Item.");
    }

    public void clicktoContactsSettingsAty(){
        clickElement(contacts_settings);
        logger.info("Click Contacts Settings Item.");
    }

    public void clicktoTellafriendAty(){
        clickElement(tell_a_friend);
        logger.info("Click Tell a Friend Item.");
    }

    public void clicktoNotificationsAty(){
        clickElement(notifications);
        logger.info("Click Notifications Item.");
    }

    public void clicktoHelpAty(){
        clickElement(help);
        logger.info("Click Help Item.");
    }

    public void clicktoAboutAty(){
        clickElement(about);
        logger.info("Click About Item.");
    }


    //click Logout
    public void clicktoLogout(){
        clickElement(logout);
        logger.info("Click Logout Item.");
        getAlertContent();
    }


}
