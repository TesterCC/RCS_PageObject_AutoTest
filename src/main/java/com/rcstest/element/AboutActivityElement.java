package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Yanxi Li on 2016/4/25.
 */
public class AboutActivityElement {

    public static final String title =  GlobalSettings.packageName + ":id/my_account";

    public static final String app_version = GlobalSettings.packageName + ":id/app_version";

    public static final String terms_conditions = GlobalSettings.packageName + ":id/setting_terms";

    public static String getTitle() {
        return title;
    }

    public static String getApp_version() {
        return app_version;
    }

    public static String getTerms_condition() {
        return terms_conditions;
    }
}
