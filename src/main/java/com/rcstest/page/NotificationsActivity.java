package com.rcstest.page;

import com.rcstest.element.NotificationsActivityElement;
import com.rcstest.module.PageElementsCheck;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Yanxi Li on 2016/4/22.
 */
public class NotificationsActivity extends BaseActivity implements PageElementsCheck{

    Logger logger = Logger.getLogger(NotificationsActivity.class);

    public NotificationsActivity(AndroidDriver<WebElement> driver){
        super(driver);
    }

    public void PageElementsCheck(AndroidDriver<WebElement> driver) {
        WebElement title = null;
        WebElement notifications_switch = null;
        try{
            title = driver.findElementById(NotificationsActivityElement.getTitle());
            notifications_switch = driver.findElementById(NotificationsActivityElement.getNotifications_switch());
            logger.info("Find All Elements.");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Can't find Element."+"\n"+e.getMessage());
        }
    }


    @AndroidFindBy(id = NotificationsActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = NotificationsActivityElement.notifications_switch)
    public WebElement notifications_switch;


    public void checkNotificationsTitle(){
        checkElementText(title,"Notifications");
    }

    public void clickNotificationsSwitch(String OFFON) throws InterruptedException {
        boolean cmpresult = (notifications_switch.getText().contains(OFFON));

        logger.info("Compare Result:"+cmpresult+".\nnotifications_switch text is: "+ notifications_switch.getText());
        if(cmpresult){
            clickBackBtn();
            logger.info("Click Back Button to More Activity.");
        }
        else{
            clickElement(notifications_switch);
            logger.info("Click Notifications switch.");
        }

    }


}
