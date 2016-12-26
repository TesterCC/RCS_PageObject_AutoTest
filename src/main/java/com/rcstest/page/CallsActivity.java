package com.rcstest.page;

import com.rcstest.element.CallsActivityElement;
import com.rcstest.element.ContactsActivityElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by PavilionLYX on 2016/4/5.
 */
public class CallsActivity extends BaseActivity {

    Logger logger  =  Logger.getLogger(CallsActivity.class);

    public CallsActivity(AndroidDriver<WebElement> driver){
        super(driver);
    }

    @AndroidFindBy(id = CallsActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = CallsActivityElement.dialer)
    public WebElement dialer;

    @AndroidFindBy(id = CallsActivityElement.all_calllog)
    public WebElement all_calllog;

    @AndroidFindBy(id = CallsActivityElement.missed_calllog)
    public WebElement missed_calllog;

    @AndroidFindBy(id = CallsActivityElement.history_call_day)
    public WebElement history_call_day;

    @AndroidFindBy(id = CallsActivityElement.calls_detail)
    public WebElement calls_detail;


    //click to Dialer Activity
    public void clicktoDialer() throws InterruptedException {
        dialer.click();
        logger.info("Click to Dialer Activity.");
        Thread.sleep(500);
    }

}
