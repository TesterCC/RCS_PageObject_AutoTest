package com.rcstest.page;

import com.rcstest.element.StatusActivityElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Yanxi Li on 2016/4/21.
 */
public class StatusActivity extends BaseActivity{

    Logger logger  =  Logger.getLogger(StatusActivity.class);

    public StatusActivity(AndroidDriver<WebElement> driver){
        super(driver);
    }


    @AndroidFindBy(xpath = StatusActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = StatusActivityElement.edit_status)
    public WebElement edit_status;

    @AndroidFindBy(id = StatusActivityElement.status)
    public WebElement status;


    //method
    public void clickEditStatus() throws InterruptedException {
        clickElement(edit_status);
        logger.info("Click to Edit status");
        Thread.sleep(500);
    }

    //Method get listsview

    public void clickStatusNamelistview(AndroidDriver<WebElement> driver) throws InterruptedException {
        clickStatusNamelistview(driver,0);
        logger.info("Click 1st item.");
        Thread.sleep(500);
    }

    /**
     * clickStatusNamelistview
     * @param driver
     * @param index
     *
     * */
    public void clickStatusNamelistview(AndroidDriver<WebElement> driver, int index) throws InterruptedException {
        List<WebElement> statusname_listview = driver.findElementsById(StatusActivityElement.getStatus_name());
        statusname_listview.get(index).click();
        logger.info("Click "+ index +" item.");
        Thread.sleep(500);

    }

    public void getStatusnamelistview(AndroidDriver<WebElement> driver){
        List<WebElement> statusnamelist = driver.findElementsById(StatusActivityElement.getStatus_name());
        for (int i = 0;i < statusnamelist.size();i++){
            String status_name = statusnamelist.get(i).getText();
            logger.info("Status name is:"+status_name+"\n");
        }
        logger.info("Traverse Statusname Listview,Fin.");
    }




}
