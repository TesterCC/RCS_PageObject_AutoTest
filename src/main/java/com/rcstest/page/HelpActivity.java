package com.rcstest.page;

import com.rcstest.element.HelpActivityElement;
import com.rcstest.module.PageElementsCheck;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by PavilionLYX on 2016/3/29.
 */
public class HelpActivity extends BaseActivity implements PageElementsCheck{

    private final static Logger logger  =  Logger.getLogger(HelpActivity.class);
    private static String propertyFile = "elements_en.properties";


    public HelpActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }


    public void PageElementsCheck(AndroidDriver<WebElement> driver) {
        WebElement back_btn = null;
        WebElement title = null;
        WebElement app_version = null;
        WebElement faqs = null;
        WebElement send_feedback = null;
        WebElement report_a_bug = null;

        try {
            back_btn = driver.findElementById(HelpActivityElement.getBack_btn());
            title = driver.findElementByXPath(HelpActivityElement.getTitle());
            app_version  = driver.findElementById(HelpActivityElement.getApp_version());
            faqs = driver.findElementById(HelpActivityElement.getFaqs());
            send_feedback = driver.findElementById(HelpActivityElement.getSend_feedback());
            report_a_bug = driver.findElementById(HelpActivityElement.getReport_a_bug());
            logger.info("Find All Elements.");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Can't find Element."+"\n"+e.getMessage());

        }

    }


    //define in HelpAty, also can call in BaseAty
    @AndroidFindBy(id = HelpActivityElement.back_btn)
    public WebElement back_btn;

    @AndroidFindBy(xpath = HelpActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = HelpActivityElement.app_version)
    public WebElement app_version;

    @AndroidFindBy(id = HelpActivityElement.faqs)
    public WebElement faqs;

    @AndroidFindBy(id = HelpActivityElement.send_feedback)
    public WebElement send_feedback;

    @AndroidFindBy(id = HelpActivityElement.report_a_bug)
    public WebElement report_a_bug;


    //in help
    public void helptoLogin() throws InterruptedException {
        back_btn.click();
        logger.info("Click and from Help Activity to Login Activity.");
        Thread.sleep(500);
    }

    //check app info
    public void checkAppinfo() {
        logger.info("ActivityName: "+ title.getText());

        if(app_version.getText().toString()=="1.2.0.0"){
            logger.warn("This is developer debug version, is not production version.");
        }else{
            logger.info("Version : "+ app_version.getText());
        }
    }


}
