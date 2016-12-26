package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Yanxi Li on 2016/4/7.
 */
public class ContactsSettingsActivityElement {

    public static final String title = "//android.widget.TextView[contains(@index,1)]"; //xpath

    public static final String  backup_contacts = GlobalSettings.packageName + ":id/nab_upload";

    public static final String  restore_contacts = GlobalSettings.packageName + ":id/nab_download";

    public static String getTitle() {
        return title;
    }

    public static String getBackup_contacts() {
        return backup_contacts;
    }

    public static String getRetore_contacts() {
        return restore_contacts;
    }
}
