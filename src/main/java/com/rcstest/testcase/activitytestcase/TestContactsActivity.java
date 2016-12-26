package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.ContactsActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Li Yanxi on 2016/4/1.
 */
public class TestContactsActivity {

    private AndroidDriver<WebElement> driver;
    private static final Logger logger = Logger.getLogger(TestContactsActivity.class);

    @Test(groups = {"ContactsAty"},priority = 1)
    public void testContactsActivity() throws Exception {

        InitialDriver.checkAty("Contacts");

        ContactsActivity contactsaty = new ContactsActivity(driver);
        contactsaty.clickContactsMainbtn();
        contactsaty.clickSearchBtn();
        driver.hideKeyboard();
        contactsaty.clickBackBtn();
        Thread.sleep(1000);


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
