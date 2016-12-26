package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Yanxi Li on 2016/4/21.
 */
public class StatusActivityElement {
    public static final String title = "//android.widget.TextView[contains(@index,1)]"; //xpath
    public static final String edit_status = GlobalSettings.packageName + ":id/editButton";
    public static final String status = GlobalSettings.packageName + ":id/status_edittext";

    public static final String status_name = GlobalSettings.packageName + ":id/status_name";


    public static String getTitle() {
        return title;
    }

    public static String getEdit_status() {
        return edit_status;
    }

    public static String getStatus() {
        return status;
    }

    public static String getStatus_name() {
        return status_name;
    }
}
