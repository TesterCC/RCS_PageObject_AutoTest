package com.rcstest.driver;

import com.rcstest.settings.GlobalSettings;
import com.rcstest.utils.DateTimeUtil;
import com.rcstest.utils.FileUtil;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;


/**
 *
 * InitialDriver:A class for encapsulating driver for launch app.
 * Created by Li Yanxi on 2016/3/15.
 *
 * @author Li Yanxi
 * @version 1.0
 *
 */

public class InitialDriver {

    private static final Logger logger = Logger.getLogger(InitialDriver.class);
    public static AndroidDriver<WebElement> driver;

    public static AndroidDriver<WebElement> launchApp() throws Exception {
        //Method 1:读取log4j的配置文件log4j.xml的配置信息，之后其他类都可以使用Log类做日志打印
//    	DOMConfigurator.configure("log4j.xml"); //or use log4j.properties
        //Method 2:Log4J支持两种文件形式的配置文件：properties文件和xml文件，
        //它们分别对应PropertyConfigurator类和DOMConfigurator类。

        PropertyConfigurator.configure(GlobalSettings.log4jConfig);// log4j.properties

        logger.info("==========Start to Launch App.==========");

        //Setup appium capabilities, some variables are global variable.

        //File classpathRoot = new File(System.getProperty("user.dir"));
        //File appDir = new File(classpathRoot, "../../../apps/ContactManager");
        //File app = new File(appDir, "ContactManager.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("deviceName", GlobalSettings.deviceName);
        capabilities.setCapability("udid", GlobalSettings.deviceUdid);
        capabilities.setCapability("platformName", GlobalSettings.platformName);
        capabilities.setCapability("platformVersion", GlobalSettings.platformVersion);
        capabilities.setCapability("appPackage", GlobalSettings.packageName);
        //Here is launch activity
        capabilities.setCapability("appActivity", GlobalSettings.launchactivityName);

        //for debug,wait for special Activity
//        capabilities.setCapability("appWaitActivity", GlobalSettings.waitactivityName);


        //After 1.3.3,can input Chinese
        /*using a specialized keyboard that allows the text to be passed as ASCII text between
         * Appium and the application being tested.
         *  配置为true,会自动使用输入法 Appium Android Input Manager for Unicode，
         *  必须要有这个配置才能支持输入中文。*/
        //capabilities.setCapability("unicodeKeyboard","True");
        /*return the keyboard to its original state.without this capability,Unicode keyboard will remain
         * enabled on the device after the tests are completed.自定义是否还原输入法。*/
        //capabilities.setCapability("resetKeyboard", "True");

        driver = new AndroidDriver<WebElement>(new URL(GlobalSettings.driverUrl), capabilities);//manual change
        driver.isAppInstalled(GlobalSettings.packageName);


        Thread.sleep(7000);
        logger.info("Sleep 7 seconds.");

        return driver;
    }

    //可以直接调用 InitialDriver.killApp();
    public static void killApp() throws Exception {

        Logger logger  =  Logger.getLogger(InitialDriver.class);

        // 1 - old method - deprecated
//    	driver.closeApp(); //just home , now have new method instead of.

        logger.info("Completely kill current app.");

        // 2 - method
        driver.pressKeyCode(187);
        //About key code 187,
        //more info can be found: http://developer.android.com/reference/android/view/KeyEvent.html
//        public static final int KEYCODE_APP_SWITCH
//        Added in API level 11
//        Key code constant: App switch key. Should bring up the application switcher dialog.
//        Constant Value: 187 (0x000000bb)

        //Use com.android.systemui control. Close current app.
        WebElement closeBtn = driver.findElementById("com.android.systemui:id/dismiss_task");
        closeBtn.click();
        logger.info("==========Close and kill test app.==========");

        //Close all apps if need close more than one process.
//		WebElement closeAllBtn = driver.findElementById("com.android.systemui:id/recents_RemoveAll_button_kk");
//		closeAllBtn.click();

        driver.closeApp();


        logger.info("==========Close to home..==========");


        //driver.quit(); // if not quit, when you restart to run testcase, appium will report error.
        //driver.closeApp(); //don't use with quit(); at the same time
        //driver.lockScreen(3);
    }


    //考虑到driver的问题，最优选择是把在InitialDriver中封装常用测试方法 -- 也可以封装到其他类：如:EncapsulationAction
    //在程序中的调用方法:InitialDriver.method();
    //Encapsulated Action

    //1.Longpress Botton-long time,for test send voice
    public static void longpressbtn(WebElement element,int time){
        try{
            TouchAction longpressbtn = new TouchAction(driver);
            longpressbtn.longPress(element,time).release().perform(); //time unit 1000ms
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //2. Check Current Activity
    public static void currentAty(){
        Logger logger  =  Logger.getLogger(InitialDriver.class);
        logger.info("Current Activity --> " + driver.currentActivity());
    }

    //3.Check Activity
    public static void checkAty(String expKeyword){
//    	Boolean bl = driver.currentActivity().contains(expKeyword);
        Boolean bl = driver.getPageSource().contains(expKeyword);

        Logger logger  =  Logger.getLogger(InitialDriver.class);

        if (bl){
            logger.info("Jump to right page:-->" + driver.currentActivity());
        }else{
            logger.error("Jump to wrong page:-->" + driver.currentActivity());
        }
    }


//4.Take Screenshot
    /**
     * takeTakesScreenshot1
     * @param driver
     * @see DateTimeUtil FileUtil
     * */
    //    String picDir = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    public static void takeTakesScreenshot(AndroidDriver<WebElement> driver){
//        String time = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String time = DateTimeUtil.formatedTime("yyyyMMdd");
        String picDir = "D:\\"+time+"_screenshot";
        try{
            //call DateUtil class method,generate screenshot's name
            if (!new File(picDir).exists()){
                FileUtil.createDir(picDir);
            }

            String filePath = picDir+"\\"+ DateTimeUtil.formatedTime("yyyyMMdd_HHmmssSSS")+".png";

            //Capture screenshot,save it in srcFile
            File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //write screenshot into disk,generate screenshot.png
            FileUtils.copyFile(srcFile,new File(filePath));
            logger.info("Take screenshot success.");
        }catch (Exception e){
            logger.error("Take screenshot failed."+e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * takeTakesScreenshot2
     * @param driver
     * @param picDir setting by user
     * @see DateTimeUtil FileUtil
     * */
    public static void takeTakesScreenshot(AndroidDriver<WebElement> driver,String picDir){
        try{
            //call DateUtil class method,generate screenshot's name
            if (!new File(picDir).exists()){
                FileUtil.createDir(picDir);
            }

            String filePath = picDir+"\\"+ DateTimeUtil.formatedTime("yyyyMMdd_HHmmssSSS")+".png";

            //Capture screenshot,save it in srcFile
            File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //write screenshot into disk,generate screenshot.png
            FileUtils.copyFile(srcFile,new File(filePath));
            logger.info("Take screenshot success.");
        }catch (Exception e){
            logger.error("Take screenshot failed."+e.getMessage());
            e.printStackTrace();
        }
    }

    //5.find element
    /**
     * try find element 1
     * @param idlocator
     *
     * */
    public static boolean elementisExistId(String idlocator){
        WebElement element = null;
        try{
            element = driver.findElementById(idlocator);
            logger.info("Element is find.");
            return true;
        }catch (Exception e){
            logger.error("Element is not find."+e.getMessage());
            return false;
        }
    }

    /**
     * try find element 2
     * @param xpathlocator
     *
     * */
    public static boolean elementisExistXPath(String xpathlocator){
        WebElement element = null;
        try{
            element = driver.findElementByXPath(xpathlocator);
            logger.info("Element is find.");
            return true;
        }catch (Exception e){
            logger.error("Element is not find."+e.getMessage());
            return false;
        }
    }

    //6. clear and input
    /**
     * clear and input
     * @param element
     * @param text
     *
     * */

    public static void clearandInput(WebElement element,String text) throws InterruptedException {
        element.click();
        element.clear();
        element.sendKeys(text);
        Thread.sleep(1000);
        logger.info("Finish clear and input operation.");
    }


    //Action 7 -- RCS take photo use system camera

    //Action 8 -- RCS choose photo from system


}

