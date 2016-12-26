package com.rcstest.page;

import com.rcstest.element.BaseActivityElement;
import com.rcstest.module.MainButton;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Li Yanxi on 2016/3/29.
 */
public class BaseActivity implements MainButton{

    private final static Logger logger  =  Logger.getLogger(BaseActivity.class);

    public BaseActivity(AndroidDriver<WebElement> driver) {
        //Initial PageFactory, setting after 7 seconds timeout.
        PageFactory.initElements(new AppiumFieldDecorator(driver,7, TimeUnit.SECONDS), this);

    }

    //Use Page Object Model to locate element

    //in Login Activity.
    @AndroidFindBy(id = BaseActivityElement.alert_content)
    public WebElement alert_content;

    @AndroidFindBy(id = BaseActivityElement.yes_btn)
    public WebElement yes_btn;

    @AndroidFindBy(id = BaseActivityElement.no_btn)
    public WebElement no_btn;

    //after login,when multi-device login
    @AndroidFindBy(id = BaseActivityElement.retry_btn)
    public WebElement multi_ok_btn;

    //in OTP Activity,after Login successfully.
    @AndroidFindBy(id = BaseActivityElement.check_img)
    public WebElement check_img;  //check button


    //in Contacts Settings activity
    @AndroidFindBy(id = BaseActivityElement.ok_btn)
    public WebElement ok_btn;


    //Title Bar -- back button
    @AndroidFindBy(id = BaseActivityElement.back_btn)
    public WebElement back_btn;


    //4 main button in app
    @AndroidFindBy(id = BaseActivityElement.chat_main_btn)
    public WebElement chat_main_btn;

    @AndroidFindBy(id = BaseActivityElement.calls_main_btn)
    public WebElement calls_main_btn;

    @AndroidFindBy(id = BaseActivityElement.contacts_main_btn)
    public WebElement contacts_main_btn;

    @AndroidFindBy(id = BaseActivityElement.more_main_btn)
    public WebElement more_main_btn;


    //When take photos -- call camera , choose photo or cancel
    @AndroidFindBy(id = BaseActivityElement.take_a_photo)
    public WebElement take_a_photo;

    @AndroidFindBy(id = BaseActivityElement.choose_photo)
    public WebElement choose_photo;

    @AndroidFindBy(id = BaseActivityElement.cancel_photo)
    public WebElement cancel_photo;




    //encapsulate method


    //in login and logout, get alert text.
    public void getAlertContent(){
        logger.info("Get the alert content is : " + alert_content.getText());
    }

    //in login , method to choose.
    public void clickYes() throws InterruptedException{
        yes_btn.click();
        logger.info("Click Yes.");
        Thread.sleep(500);
    }

    public void clickNo() throws InterruptedException{
        no_btn.click();
        logger.info("Click No.");
        Thread.sleep(500);
    }

    //in OTP
    public void clickCheckimg() throws InterruptedException {
        check_img.click();
        logger.info("Click Check img.");
        Thread.sleep(500);
    }



    //Title bar
    public void clickBackBtn() throws InterruptedException {
        back_btn.click();
        logger.info("Click top-left back button.");
        Thread.sleep(500);
    }


    public void clickChatsMainbtn() {
        chat_main_btn.click();
        logger.info("Click Chats Button.");
    }

    public void clickCallsMainbtn() {
        calls_main_btn.click();
        logger.info("Click Calls Button.");

    }

    public void clickContactsMainbtn() {
        contacts_main_btn.click();
        logger.info("Click Contacts Button.");

    }

    public void clickMoreMainbtn() {
        more_main_btn.click();
        logger.info("Click More Button.");

    }


    public void clickElement(WebElement el){
        el.click();
        logger.info("Click Element.");
    }


    public void clickAlertOKbtn(){
        ok_btn.click();
        logger.info("Click Alert OK button.");
    }


    //Click to decide take photo or not--use clickElement method() directly.
//stub



    //click multi device alert
    public void clickMultideviceAlert(AndroidDriver<WebElement> driver){
        WebElement multi_ok_btn= null;
        boolean bl = alert_content.getText().contains("You have logged"); //at the moment
        if(bl == true){
        try{
            multi_ok_btn = driver.findElementById(BaseActivityElement.getRetry_btn());
            multi_ok_btn.click();
            logger.info("Click OK to confirm multi-device login.");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Can't find multi-device alert."+"\n"+e.getMessage());
        }
        }else{
            logger.info("clickMultideviceAlert()--> Can't find prompt message.");
        }
    }



    //check title
    public void checkElementText(WebElement element,String expKeyword){
        if(element.getText()==expKeyword){
            logger.info("Get expect text on specified element.");
        }else{
            logger.error("Can't get expcet text on specified element.");
        }
    }

}

//Web
//    By greetingLocator = By.cssSelector("#wp-admin-bar-my-account .ab-item");
//
//    public WebElement getGreetinglink() {
//        return this.dr.findElement(greetingLocator);
//    }