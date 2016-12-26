package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.ChatCallSettingsActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Yanxi Li on 2016/4/25.
 */
public class TestChatCallSettingsActivity {

    private AndroidDriver<WebElement> driver;
    private static final Logger logger = Logger.getLogger(TestChatCallSettingsActivity.class);

    @Test(groups = {"ChatCallSettingsAty"},priority = 1)
    public void testChatCallSettingsActivity() throws Exception {
        ChatCallSettingsActivity ccs = new ChatCallSettingsActivity(driver);

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
