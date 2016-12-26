package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Yanxi Li on 2016/4/25.
 */
public class ChatCallSettingsActivityElement {

    public static final String title = "//android.widget.TextView[contains(@index,1)]"; //xpath

    public static final String media_auto_download_switch = GlobalSettings.packageName + ":id/media_download_auto_control";

    public static final String sms_to_im_switch = GlobalSettings.packageName + ":id/ip_sms_control";

    public static final String call_waiting_switch = GlobalSettings.packageName + ":id/call_waiting_control";

    public static final String call_forwarding = GlobalSettings.packageName + ":id/call_forwarding";

    public static final String font_size = GlobalSettings.packageName + ":id/font_size";

    public static final String current_font_size = GlobalSettings.packageName + ":id/font_size_tv";

    public static final String delete_all_conversations = GlobalSettings.packageName + ":id/delete_conversations";

    public static final String clear_calls_history =  GlobalSettings.packageName + ":id/clear_call_history";

    public static String getTitle() {
        return title;
    }

    public static String getClear_calls_history() {
        return clear_calls_history;
    }

    public static String getMedia_auto_download_switch() {
        return media_auto_download_switch;
    }

    public static String getSms_to_im_switch() {
        return sms_to_im_switch;
    }

    public static String getCall_waiting_switch() {
        return call_waiting_switch;
    }

    public static String getCall_forwarding() {
        return call_forwarding;
    }

    public static String getFont_size() {
        return font_size;
    }

    public static String getCurrent_font_size() {
        return current_font_size;
    }

    public static String getDelete_all_conversations() {
        return delete_all_conversations;
    }
}
