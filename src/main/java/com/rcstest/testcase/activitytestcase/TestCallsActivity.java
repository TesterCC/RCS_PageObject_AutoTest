package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.CallsActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by PavilionLYX on 2016/4/5.
 */
public class TestCallsActivity {

    private AndroidDriver<WebElement> driver;
    private static final Logger logger = Logger.getLogger(TestCallsActivity.class);

    @Test(groups = {"CallsAty"},priority = 1)
    public void testCallsActivity() throws Exception {

        CallsActivity callsaty = new CallsActivity(driver);
        callsaty.clickCallsMainbtn();
        InitialDriver.checkAty("Calls");
        Thread.sleep(1000);

        callsaty.clicktoDialer();
        Thread.sleep(1000);
        callsaty.clickBackBtn();
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
