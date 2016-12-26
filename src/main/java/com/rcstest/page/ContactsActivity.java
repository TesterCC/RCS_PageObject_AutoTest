package com.rcstest.page;

import com.rcstest.element.ContactsActivityElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Li Yanxi on 2016/4/1.
 */
public class ContactsActivity extends BaseActivity {

    Logger logger  =  Logger.getLogger(ContactsActivity.class);

    public ContactsActivity(AndroidDriver<WebElement> driver){
        super(driver);
    }


    @AndroidFindBy(id = ContactsActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = ContactsActivityElement.search_btn)
    public WebElement search_btn;

    @AndroidFindBy(id = ContactsActivityElement.back_btn)
    public WebElement search_back_btn;

    @AndroidFindBy(id = ContactsActivityElement.new_contact)
    public WebElement add_new_contact;

    @AndroidFindBy(id = ContactsActivityElement.rcs_contacts)
    public WebElement rcs_contacts;

    @AndroidFindBy(id = ContactsActivityElement.all_contacts)
    public WebElement all_contacts;


    public void clickSearchBtn(){
        clickElement(search_btn);
        logger.info("Click search button.");
    }

    //troubles
//    public void clickSearchBackBtn(){
//        clickElement(search_back_btn);
//        logger.info("Click search back button.");
//    }

    public void clickAddNewBtn(){
        clickElement(add_new_contact);
        logger.info("Click add new contact button. Jump to system contacts.");
    }

    public void clickMessagelist(){
        clickElement(rcs_contacts);
        logger.info("Click Message+ list bar.");
    }

    public void clickAlllist(){
        clickElement(all_contacts);
        logger.info("Click All list bar.");
    }

}
