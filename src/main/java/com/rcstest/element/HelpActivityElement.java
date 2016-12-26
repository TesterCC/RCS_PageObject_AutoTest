package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Li Yanxi on 2016/3/29.
 */
public class HelpActivityElement {

    //e.g. xpath
//    el = driver.findElementByXPath("//android.widget.TextView[contains(@index,1)]");
//    el = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Help')]");

    //in Help screen back button
    public static final String back_btn = GlobalSettings.packageName + ":id/back_button";
    public static final String title = "//android.widget.TextView[contains(@index,1)]"; //xpath
    public static final String app_version = GlobalSettings.packageName + ":id/app_version";
    public static final String faqs = GlobalSettings.packageName + ":id/faqs";
    public static final String send_feedback = GlobalSettings.packageName + ":id/send_feedback";
    public static final String report_a_bug = GlobalSettings.packageName + ":id/upload_huawei_log";





    public static String getBack_btn() {
        return back_btn;
    }

    public static String getTitle() {
        return title;
    }

    public static String getApp_version() {
        return app_version;
    }

    public static String getFaqs() {
        return faqs;
    }

    public static String getSend_feedback() {
        return send_feedback;
    }

    public static String getReport_a_bug() {
        return report_a_bug;
    }
}
