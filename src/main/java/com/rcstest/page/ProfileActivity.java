package com.rcstest.page;

import com.rcstest.element.ProfileActivityElement;
import com.rcstest.module.PageElementsCheck;
import com.rcstest.module.TakePhoto;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Yanxi Li on 2016/4/20.
 */
public class ProfileActivity extends BaseActivity implements PageElementsCheck,TakePhoto{

    Logger logger  =  Logger.getLogger(ProfileActivity.class);

    public ProfileActivity(AndroidDriver<WebElement> driver){

        super(driver);

    }

    public void PageElementsCheck(AndroidDriver<WebElement> driver) {
        WebElement nickname = null;
        WebElement account_number = null;
        WebElement my_status_show = null;
        try{
            nickname = driver.findElementById(ProfileActivityElement.getNickname());
            account_number = driver.findElementById(ProfileActivityElement.getAccount_number());
            my_status_show = driver.findElementById(ProfileActivityElement.getMy_status_show());

            logger.info("Find All Elements.");
        }catch(Exception e){
            e.printStackTrace();
            logger.error("Can't find Element."+"\n"+e.getMessage());
        }
    }


    @AndroidFindBy(id = ProfileActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = ProfileActivityElement.edit_avatar)
    public WebElement edit_avatar;
//Edit nickname or save
    @AndroidFindBy(id = ProfileActivityElement.edit_nickname)
    public WebElement edit_nickname;

    @AndroidFindBy(id = ProfileActivityElement.nickname)
    public WebElement nickname;

    @AndroidFindBy(id = ProfileActivityElement.account_number)
    public WebElement account_number;

    @AndroidFindBy(id = ProfileActivityElement.my_status_show)
    public WebElement my_status_show;

    @AndroidFindBy(id = ProfileActivityElement.setting_status)
    public WebElement setting_status;



    //take photo method
    public void clickTakeAPhoto() {
        clickElement(take_a_photo);
        logger.info("Click to Take a Photo.");
    }

    public void clickChoosePhoto() {
        clickElement(choose_photo);
        logger.info("Click to Choose Photo.");
    }

    public void clickCancelPhoto() {
        clickElement(cancel_photo);
        logger.info("Click to Cancel Photo.");
    }

    //normal
    public void clickEditAvatar(){
        clickElement(edit_avatar);
        logger.info("Click to Edit Portarit.");
    }
    public void clickEditNickname(){
        clickElement(edit_nickname);
        logger.info("Click to Edit/Save Nickname.");
    }

    public void clicktoStatusAty() throws InterruptedException {
        clickElement(setting_status);
        logger.info("Click to Status Activity.");
        Thread.sleep(500);
    }

}
