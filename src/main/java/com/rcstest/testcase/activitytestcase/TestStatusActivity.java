package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.BaseActivity;
import com.rcstest.page.MoreActivity;
import com.rcstest.page.ProfileActivity;
import com.rcstest.page.StatusActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Yanxi Li on 2016/4/21.
 */
public class TestStatusActivity {

    private AndroidDriver<WebElement> driver;

    private static final Logger logger = Logger.getLogger(TestStatusActivity.class);

    @Test(groups = {"StatusAty"},priority = 1)
    public void testStatusActivity() throws Exception {
        //to Status Activity
        BaseActivity ba = new BaseActivity(driver);
        ba.clickMoreMainbtn();

        MoreActivity ma = new MoreActivity(driver);
        ma.clicktoProfileAty();

        ProfileActivity pa = new ProfileActivity(driver);
        pa.clicktoStatusAty();

        //test Status Activity
        StatusActivity sa = new StatusActivity(driver);

        InitialDriver.checkAty("CURRENT STATUS");

        sa.getStatusnamelistview(driver);  //check litsview

        sa.clickStatusNamelistview(driver);//default index 0, I am new to Message+!
        InitialDriver.takeTakesScreenshot(driver);

        sa.clickStatusNamelistview(driver,3);//choose index
        InitialDriver.takeTakesScreenshot(driver);

        sa.clickEditStatus();
        InitialDriver.clearandInput(sa.status,"No pain,no gain.");
        sa.clickEditStatus();

        sa.clickBackBtn();
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
