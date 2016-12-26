package com.rcstest.page;

import com.rcstest.element.SelectContactActivityElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by PavilionLYX on 2016/4/5.
 */
public class SelectContactActivity extends BaseActivity{

    Logger logger  =  Logger.getLogger(SelectContactActivity.class);

    public SelectContactActivity(AndroidDriver<WebElement> driver){
        super(driver);
    }

    @AndroidFindBy(id = SelectContactActivityElement.title)
    public WebElement title;

    @AndroidFindBy(id = SelectContactActivityElement.search_edittext)
    public WebElement search_edittext;

    @AndroidFindBy(id = SelectContactActivityElement.back_btn)
    public WebElement search_back_btn;

    @AndroidFindBy(id = SelectContactActivityElement.rcs_contacts)
    public WebElement rcs_contacts;

    @AndroidFindBy(id = SelectContactActivityElement.all_contacts)
    public WebElement all_contacts;

    @AndroidFindBy(id = SelectContactActivityElement.search_result)
    public WebElement search_result;

    public void clickMessagelist(){
        clickElement(rcs_contacts);
        logger.info("Click Message+ list bar.");
    }

    public void clickAlllist(){
        clickElement(all_contacts);
        logger.info("Click All list bar.");
    }

    public void searchContacts(String contact_number){
        clickElement(search_edittext);
        search_edittext.sendKeys(contact_number);
        logger.info("Search specify contact.");
    }

    public void clickSearchResult(){
        clickElement(search_result);
        logger.info("Click serach result.");
    }

}
