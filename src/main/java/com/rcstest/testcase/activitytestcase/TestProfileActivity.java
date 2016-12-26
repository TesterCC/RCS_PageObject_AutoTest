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
 * Created by Yanxi Li on 2016/4/20.
 */
public class TestProfileActivity {

    //need to add <WebElement>
    private AndroidDriver<WebElement> driver;

    private static final Logger logger = Logger.getLogger(TestProfileActivity.class);

    @Test(groups = {"MoreAty"},priority = 1)
    public void testProfileActivity() throws Exception {
        BaseActivity ba = new BaseActivity(driver);
        ba.clickMoreMainbtn();

        MoreActivity ma = new MoreActivity(driver);
        ma.clicktoProfileAty();

        ProfileActivity pa = new ProfileActivity(driver);
        pa.clickEditAvatar();
        Thread.sleep(500);
        pa.clickCancelPhoto();

        pa.clickEditNickname();
        InitialDriver.clearandInput(pa.nickname,"Auto_Change_5408");
        pa.clickEditNickname();

        pa.clicktoStatusAty();
        InitialDriver.takeTakesScreenshot(driver);

//        pa.clickBackBtn();//not recommand use pa,because it's in Status Activity now.
        StatusActivity sa = new StatusActivity(driver);
        sa.clickBackBtn();

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
