package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.BaseActivity;
import com.rcstest.page.MoreActivity;
import com.rcstest.page.NotificationsActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Yanxi Li on 2016/4/22.
 */
public class TestNotificationsActivity {

    private AndroidDriver<WebElement> driver;
    private static final Logger logger = Logger.getLogger(TestNotificationsActivity.class);

    @Test(groups = {"NotificationsAty"},priority = 1)
    public void testNotificationsActivity() throws Exception {
        BaseActivity ba = new BaseActivity(driver);
        ba.clickMoreMainbtn();

        MoreActivity ma = new MoreActivity(driver);
        ma.clicktoNotificationsAty();

        NotificationsActivity na = new NotificationsActivity(driver);
//        na.checkElementText(na.title,"Notifications");
        na.checkNotificationsTitle();

        na.clickNotificationsSwitch("ON");//OFF or ON

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
