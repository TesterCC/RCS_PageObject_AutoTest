package com.rcstest.customaction;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 *
 * A class for encapsulating Custom Action -- can use
 * @author Yanxi
 * @version 1.0
 *
 */

public class CustomAction{

    private final static Logger logger  =  Logger.getLogger(CustomAction.class);

    //in testcase class,can initialized it and call method.

    //Action 1 -- output current activity
    public static void currentAty(AndroidDriver<WebElement> driver){
		Logger logger  =  Logger.getLogger(CustomAction.class);
    	logger.info("Current Activity --> "+driver.currentActivity());
    }	
    
//	Action 2 -- longpress on element
	public static void longPress(AndroidDriver<WebElement> driver,By by, int duration){
		try{
			WebElement element=driver.findElement(by);
			TouchAction ta = new TouchAction(driver);
			ta.longPress(element,duration).release().perform();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


    //Action 3 -- Check Activity
    public static void checkAty(AndroidDriver<WebElement> driver,String expKeyword){
//    	Boolean bl = driver.currentActivity().contains(expKeyword);
        Boolean bl = driver.getPageSource().contains(expKeyword);

        if (bl==true){
            logger.info("Jump to right page:-->" + driver.currentActivity());
        }else{
            logger.error("Jump to wrong page:-->" + driver.currentActivity());
        }
    }

    //Action 7 -- RCS take photo use system camera

    //Action 8 -- RCS choose photo from system
	

}
