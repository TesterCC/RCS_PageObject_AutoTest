package com.rcstest.page;

import com.rcstest.element.ChatCallSettingsActivityElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Yanxi Li on 2016/4/25.
 */
public class ChatCallSettingsActivity extends BaseActivity{


    Logger logger = Logger.getLogger(ChatCallSettingsActivity.class);

    public ChatCallSettingsActivity(AndroidDriver<WebElement> driver){
        super(driver);
    }

    @AndroidFindBy(xpath = ChatCallSettingsActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = ChatCallSettingsActivityElement.media_auto_download_switch)
    public WebElement media_auto_download_switch;

}
