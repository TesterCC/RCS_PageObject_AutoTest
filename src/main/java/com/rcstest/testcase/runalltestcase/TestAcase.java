package com.rcstest.testcase.runalltestcase;

import com.rcstest.driver.InitialDriver;
import com.rcstest.page.LoginActivity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Class for test standalone method , please ignore it.
 * Created by Li Yanxi on 2016/3/30.
 */
public class TestAcase {
    private static final Logger logger = Logger.getLogger(TestAcase.class);
    private AndroidDriver<WebElement> driver;


    @Test(groups = {"LoginAty"},priority = 5,enabled = false)
    public void testToOtp() throws InterruptedException {
        LoginActivity la = new LoginActivity(driver);
        la.inputAccount();
        driver.hideKeyboard();


        la.clickAcceptCheckbox();
        la.checkActivateBtn();

        la.clicktoLogin();
        Thread.sleep(1000);
        la.clickYes();
        Thread.sleep(3000);

        InitialDriver.checkAty("OTP");
        la.clickCheckimg();
        InitialDriver.takeTakesScreenshot(driver);

    }

//For debugging specified testcase and method , enabled = false,跳过执行这条testcase
    @Test(groups = {"DebugCode"},priority = 1,enabled = false)
    public void testDebugCode() throws InterruptedException {
        LoginActivity la = new LoginActivity(driver);
        la.toChooseCountrycode();
        Thread.sleep(1000);

        //选择国家码65，这个需要专门封装查找
        List<WebElement> listview = driver.findElementsById("com.starhub.messageplus:id/country_code_name");

        int startx = 600;
        int starty = 2100;
        int endx = 600;
        int endy = 700;
        int duration = 1200;


//can get re:true
    for (int i = 0; i < listview.size(); i++) {
        String code = listview.get(i).getText();
        boolean bl = code.contains("+93");
        logger.warn("Country code is: " + code);
        logger.warn("re:"+ bl);
    }
        //code可以比对是否包含，还是要利用数组知识来遍历


//        if(bl==false){
//            driver.swipe(startx,starty,endx,endy,duration);
//            Thread.sleep(500);
//        }else{
//            listview.get(i).click();
//            logger.warn("Find Target.");
//            break;
//        }

        logger.warn("Test End.");







        //下面方法还是有问题，此方法暂时不做，以免耽误时间
        //估计的确是得用二维数组的思维
//        if(listview.contains("Singapore")==false){
//            while (!listview.contains("Zimbabwe")){
//            Thread.sleep(500);
//        for (WebElement el: listview){
//            logger.warn("el value is:"+el.getText());
//        }
//        driver.swipe(startx,starty,endx,endy,duration);
//            Thread.sleep(500);
//            }
//        }else{
//            logger.warn("Jump to function.");
//
//        }
//        logger.warn("Test End.");


    }


    @BeforeClass
    public void beforeMethod() throws Exception{
        driver = InitialDriver.launchApp();
    }

    @AfterClass
    public void afterMethod() throws Exception{
//		driver.closeApp(); //AppiumDriver method
        InitialDriver.killApp();
    }



}
