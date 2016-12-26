package com.rcstest.testcase.activitytestcase;


import com.rcstest.driver.InitialDriver;
import com.rcstest.element.BaseActivityElement;
import com.rcstest.page.ContactsSettingsActivity;
import com.rcstest.page.MoreActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Yanxi Li on 2016/4/7.
 */
public class TestContactsSettingsActivity {

    private AndroidDriver<WebElement> driver;
    private static final Logger logger = Logger.getLogger(TestContactsSettingsActivity.class);

    @Test(groups = {"ContactsSettings"},priority = 1)
    public void testContactsSettingsActivity() throws Exception {

        MoreActivity ma = new MoreActivity(driver);
        ma.clickMoreMainbtn();
        ma.clicktoContactsSettingsAty();

        ContactsSettingsActivity csa = new ContactsSettingsActivity(driver);

        InitialDriver.checkAty("Contacts Settings");
        csa.clicktoBackupContacts("N");
        csa.restore_contacts.click();
        boolean bb = InitialDriver.elementisExistId(BaseActivityElement.ok_btn);
        logger.info("Boolean bb is:"+bb);
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
