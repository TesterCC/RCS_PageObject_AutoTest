package com.rcstest.page;

import com.rcstest.driver.InitialDriver;
import com.rcstest.element.AboutActivityElement;
import com.rcstest.module.PageElementsCheck;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Yanxi Li on 2016/4/25.
 */
public class AboutActivity extends BaseActivity implements PageElementsCheck {

    Logger logger = Logger.getLogger(AboutActivity.class);

    public AboutActivity(AndroidDriver<WebElement> driver){
        super(driver);
    }

    public void PageElementsCheck(AndroidDriver<WebElement> driver) {
        WebElement title = null;
        WebElement app_version = null;
        WebElement terms_condition = null;
        try{
            title = driver.findElementById(AboutActivityElement.getTitle());
            app_version = driver.findElementById(AboutActivityElement.getApp_version());
            terms_condition = driver.findElementById(AboutActivityElement.getTerms_condition());
            logger.info("Find All Elements.");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Can't find Element."+"\n"+e.getMessage());
        }
    }

    @AndroidFindBy(id = AboutActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = AboutActivityElement.app_version)
    public WebElement app_version;

    @AndroidFindBy(id = AboutActivityElement.terms_conditions)
    public WebElement terms_conditons;


    public void clicktoTermsConditions() throws InterruptedException {
        terms_conditons.click();
        Thread.sleep(1000);
        InitialDriver.currentAty();
        InitialDriver.checkAty("Terms & Conditions");
    }









}
