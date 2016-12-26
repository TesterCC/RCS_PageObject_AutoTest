package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by PavilionLYX on 2016/3/29.
 */
public class BaseActivityElement {

    //Alert,single check element in page.

    //in Login Activity - in Logout Activity
    public static final String alert_content =  GlobalSettings.packageName + ":id/_reason";
    public static final String yes_btn = GlobalSettings.packageName + ":id/_ok_button";
    public static final String no_btn = GlobalSettings.packageName + ":id/_cancel_button";

    //in OTP Activity - After login successfully
    public static final String check_img = GlobalSettings.packageName + ":id/img";

    //in backup and restore contacts activity
    public static final String ok_btn = GlobalSettings.packageName + "id/_button";



    //Title Bar -- back button
    public static final String back_btn = GlobalSettings.packageName + ":id/back_button";

    //after login,when multi-device login   , alert prompt -> alert_content
    public static final String retry_btn =  GlobalSettings.packageName + ":id/_retry";



    //4 main button in app
    public static final String chat_main_btn = GlobalSettings.packageName + ":id/radio_button_chat";

    public static final String calls_main_btn = GlobalSettings.packageName + ":id/radio_button_recents";

    public static final String contacts_main_btn = GlobalSettings.packageName + ":id/radio_button_contacts";

    public static final String more_main_btn = GlobalSettings.packageName + ":id/radio_button_settings";

    //contact listview controls
    public static final String contact_letter_listview =  GlobalSettings.packageName + ":id/contact_list_letterListView";


    //When take photos -- call camera , choose photo or cancel
    public static final String take_a_photo = GlobalSettings.packageName + ":id/chat_menu_dialog_take_by_camera";
    public static final String choose_photo = GlobalSettings.packageName + ":id/chat_menu_dialog_choose_from_exist";
    public static final String cancel_photo = GlobalSettings.packageName + ":id/chat_menu_dialog_cancel_btn";





    //========get method()=======

    public static String getYes_btn() {
        return yes_btn;
    }

    public static String getNo_btn() {
        return no_btn;
    }

    public static String getCheck_img() {
        return check_img;
    }

    public static String getBack_btn() {
        return back_btn;
    }

    public static String getChat_main_btn() {
        return chat_main_btn;
    }

    public static String getCalls_main_btn() {
        return calls_main_btn;
    }

    public static String getContacts_main_btn() {
        return contacts_main_btn;
    }

    public static String getMore_main_btn() {
        return more_main_btn;
    }

    public static String getContact_letter_listview() {
        return contact_letter_listview;
    }

    public static String getAlert_content() {
        return alert_content;
    }

    public static String getRetry_btn() {
        return retry_btn;
    }

    public static String getOk_btn() {
        return ok_btn;
    }

    public static String getTake_a_photo() {
        return take_a_photo;
    }

    public static String getChoose_photo() {
        return choose_photo;
    }

    public static String getCancel_photo() {
        return cancel_photo;
    }
}
