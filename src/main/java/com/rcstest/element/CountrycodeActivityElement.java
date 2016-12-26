package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Li Yanxi on 2016/3/30.
 */
public class CountrycodeActivityElement {

    public static final String title = GlobalSettings.packageName + ":id/textView2";
    public static final String letter_list = GlobalSettings.packageName + ":id/MyLetterListView";
    public static final String back_btn = GlobalSettings.packageName + ":id/back_button";

    public static String getTitle() {
        return title;
    }

    public static String getLetter_list() {
        return letter_list;
    }

    public static String getBack_btn() {
        return back_btn;
    }
}
