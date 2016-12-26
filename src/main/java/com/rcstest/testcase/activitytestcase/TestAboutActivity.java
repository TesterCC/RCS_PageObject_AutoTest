package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.AboutActivity;
import com.rcstest.page.BaseActivity;
import com.rcstest.page.MoreActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Yanxi Li on 2016/4/25.
 */
public class TestAboutActivity {
    private AndroidDriver<WebElement> driver;
    private static final Logger logger = Logger.getLogger(TestAboutActivity.class);

    @Test(groups = {"AboutAty"},priority = 1)
    public void testAboutActivity() throws Exception {
        BaseActivity ba = new BaseActivity(driver);
        ba.clickMoreMainbtn();

        MoreActivity ma = new MoreActivity(driver);
        ma.clicktoAboutAty();

        AboutActivity aa = new AboutActivity(driver);
        aa.clicktoTermsConditions();
        InitialDriver.takeTakesScreenshot(driver);
        aa.clickBackBtn();//back to About aty
        aa.clickBackBtn();//back to More aty

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
