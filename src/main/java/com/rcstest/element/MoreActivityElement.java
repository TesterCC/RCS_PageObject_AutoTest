package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Li Yanxi on 2016/4/5.
 */
public class MoreActivityElement {

    //title
    public static final String title = GlobalSettings.packageName + ":id/title";

    //xpath

    public static final String profile = "//android.widget.TextView[contains(@text,'Profile')]";

    //Chat & Call Settings
    public static final String chatcall_settings = "//android.widget.TextView[contains(@text,'Chat & Call Settings')]";

    //Contacts Settings
    public static final String contacts_settings = "//android.widget.TextView[contains(@text,'Contacts Settings')]";

    //Tell a Friend
    public static final String tell_a_friend = "//android.widget.TextView[contains(@text,'Tell a Friend')]";

    //Notifications
    public static final String notifications = "//android.widget.TextView[contains(@text,'Notifications')]";

    //Help
    public static final String help  = "//android.widget.TextView[contains(@text,'Help')]";

    //About
    public static final String about  = "//android.widget.TextView[contains(@text,'About')]";

    //Log Out
    public static final String logout  = "//android.widget.TextView[contains(@text,'Log Out')]";


    public static String getTitle() {
        return title;
    }

    public static String getProfile() {
        return profile;
    }

    public static String getChatcall_settings() {
        return chatcall_settings;
    }

    public static String getContacts_settings() {
        return contacts_settings;
    }

    public static String getTell_a_friend() {
        return tell_a_friend;
    }

    public static String getNotifications() {
        return notifications;
    }

    public static String getHelp() {
        return help;
    }

    public static String getAbout() {
        return about;
    }

    public static String getLogout() {
        return logout;
    }
}
