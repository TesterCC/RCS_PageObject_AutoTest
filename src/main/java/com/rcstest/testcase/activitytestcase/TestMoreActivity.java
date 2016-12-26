package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.MoreActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Li Yanxi on 2016/4/5.
 */
public class TestMoreActivity {

    private AndroidDriver<WebElement> driver;
    private static final Logger logger = Logger.getLogger(TestMoreActivity.class);

    @Test(groups = {"MoreAty"},priority = 1)
    public void testMoreActivity() throws Exception {

        MoreActivity moreaty = new MoreActivity(driver);
        moreaty.clickMoreMainbtn();
        Thread.sleep(1000);
        InitialDriver.checkAty("More");
        Thread.sleep(1000);

        moreaty.clicktoTellafriendAty();
        InitialDriver.takeTakesScreenshot(driver);
        driver.pressKeyCode(4);//Android BACK key

        moreaty.clicktoLogout();
        moreaty.getAlertContent();
        moreaty.clickNo();
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
