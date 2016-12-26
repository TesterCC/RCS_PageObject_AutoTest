package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.ChatsActivity;
import com.rcstest.page.SelectContactActivity;
import com.rcstest.page.SelectContactActivityExTest;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Yanxi Li on 2016/4/5.
 */
public class TestSelectContactActivity {

    private AndroidDriver<WebElement> driver;
    private static final Logger logger = Logger.getLogger(TestSelectContactActivity.class);


    @Test(groups = {"SelectContactAty"},priority = 1)
    public void jumpToSingleChat() throws Exception {

        ChatsActivity chatsaty= new ChatsActivity(driver);
        chatsaty.clicktoAddConversation();
        SelectContactActivity sca = new SelectContactActivity(driver);
        sca.clickMessagelist();
        sca.clickAlllist();
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
