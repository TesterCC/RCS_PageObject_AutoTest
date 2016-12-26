package com.rcstest.page;


import com.rcstest.element.CountrycodeActivityElement;
import com.rcstest.module.GoBack;
import com.rcstest.module.PageElementsCheck;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Li Yanxi on 2016/3/30.
 */
public class CountrycodeActivity extends BaseActivity implements PageElementsCheck,GoBack{

    private final static Logger logger  =  Logger.getLogger(CountrycodeActivity.class);

    public CountrycodeActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    public void PageElementsCheck(AndroidDriver<WebElement> driver) {
        WebElement title = null;
        WebElement letter_list = null;
        WebElement back_btn = null;

        try{
            title = driver.findElementById(CountrycodeActivityElement.getTitle());
            letter_list = driver.findElementById(CountrycodeActivityElement.getLetter_list());
            back_btn = driver.findElementById(CountrycodeActivityElement.getBack_btn());
            logger.info("Find All Elements.");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Can't find Element."+"\n"+e.getMessage());
        }
    }


    @AndroidFindBy(id = CountrycodeActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = CountrycodeActivityElement.letter_list)
    public WebElement letter_list;

    @AndroidFindBy(id = CountrycodeActivityElement.back_btn)
    public WebElement back_btn;


    public void goBack() {
        back_btn.click();
        logger.info("Click top-left back button.");
    }
}
