package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Yanxi on 2016/4/5.
 */
public class CallsActivityElement {

    //title
    public static final String title = GlobalSettings.packageName + ":id/title";

    //to dialer activity
    public static final String dialer =  GlobalSettings.packageName + ":id/dialer";

    public static final String all_calllog =  GlobalSettings.packageName + ":id/all_calllog";

    public static final String missed_calllog = GlobalSettings.packageName + ":id/missed_calllog";


    //to call history
    public static final String calls_detail =  GlobalSettings.packageName + ":id/secondary_action_icon";

    //history call day
    public static final String history_call_day = GlobalSettings.packageName + ":id/history_call_day";


    public static String getTitle() {
        return title;
    }

    public static String getDialer() {
        return dialer;
    }

    public static String getAll_calllog() {
        return all_calllog;
    }

    public static String getMissed_calllog() {
        return missed_calllog;
    }

    public static String getCalls_detail() {
        return calls_detail;
    }

    public static String getHistory_call_day() {
        return history_call_day;
    }
}
