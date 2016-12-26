package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by PavilionLYX on 2016/4/22.
 */
public class NotificationsActivityElement {
    public static final String title = GlobalSettings.packageName + ":id/textView2";
    public static final String notifications_switch = GlobalSettings.packageName + ":id/notifaction_control";


    public static String getTitle() {
        return title;
    }

    public static String getNotifications_switch() {
        return notifications_switch;
    }
}
