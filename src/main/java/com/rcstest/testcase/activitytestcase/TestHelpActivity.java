package com.rcstest.testcase.activitytestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.ChatsActivity;
import com.rcstest.page.HelpActivity;
import com.rcstest.page.MoreActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Yanxi Li on 2016/4/12.
 */
public class TestHelpActivity {

    //need to add <WebElement>
    private AndroidDriver<WebElement> driver;
    private final static Logger logger  =  Logger.getLogger(TestHelpActivity.class);


    @Test(groups = {"HelpAty"},priority = 1)
    public void testHelpAty() throws Exception{
        //from Chats Aty to Help Aty
        ChatsActivity ca = new ChatsActivity(driver);
        ca.clickMoreMainbtn();
        MoreActivity ma = new MoreActivity(driver);
        ma.clicktoHelpAty();
        Thread.sleep(1000);
        HelpActivity ha = new HelpActivity(driver);
        ha.checkAppinfo();

    }


    @BeforeClass
    public void beforeMethod() throws Exception{
        driver = InitialDriver.launchApp();
    }

    @AfterClass
    public void afterMethod() throws Exception{
        InitialDriver.killApp();
    }
}
