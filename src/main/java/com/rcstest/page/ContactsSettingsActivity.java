package com.rcstest.page;

import com.rcstest.element.ContactsSettingsActivityElement;
import com.rcstest.module.PageElementsCheck;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Yanxi Li on 2016/4/7.
 */
public class ContactsSettingsActivity extends BaseActivity implements PageElementsCheck{

    private final static Logger logger  =  Logger.getLogger(ContactsSettingsActivity.class);

    public ContactsSettingsActivity(AndroidDriver<WebElement> driver) {

        super(driver);
    }


    public void PageElementsCheck(AndroidDriver<WebElement> driver) {
        WebElement title = null;
        WebElement backup_contacts = null;
        WebElement restore_contacts = null;

        try{
            title = driver.findElementByXPath(ContactsSettingsActivityElement.getTitle());
            backup_contacts = driver.findElementById(ContactsSettingsActivityElement.getBackup_contacts());
            restore_contacts = driver.findElementById(ContactsSettingsActivityElement.getRetore_contacts());
            logger.info("Find All Elements.");
        }catch(Exception e){
            e.printStackTrace();
            logger.error("Can't find Element."+"\n"+e.getMessage());
        }
    }


    @AndroidFindBy(id = ContactsSettingsActivityElement.backup_contacts)
    public WebElement backup_contacts;

    @AndroidFindBy(id = ContactsSettingsActivityElement.restore_contacts)
    public WebElement restore_contacts;


    //will prompt a prompt to confirm
    public void clicktoBackupContacts(String flag) throws InterruptedException {

        backup_contacts.click();
        if(flag == "Y"){
            this.clickYes();
            //logic need design
            Thread.sleep(20000);
            this.clickAlertOKbtn();
            logger.info("Backup Contacts");
        }
        if(flag == "N"){
            this.clickNo();
            logger.info("Cancel Backup Contacts");
        }

    }

    public void clicktoRestoreContacts(int timeout) throws InterruptedException {

        restore_contacts.click();
        //logic need design
        Thread.sleep(timeout);
        this.clickAlertOKbtn();
        logger.info("Backup Contacts");

    }


}
