package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Yanxi Li on 2016/4/20.
 */
public class ProfileActivityElement {

    public static final String title = GlobalSettings.packageName + ":id/textView2";

    public static final String edit_avatar = GlobalSettings.packageName + ":id/editHeadImageButton";

    public static final String nickname =  GlobalSettings.packageName + ":id/nickname";

    public static final String edit_nickname = GlobalSettings.packageName + ":id/editNickNameButton";

    public static final String account_number = GlobalSettings.packageName + ":id/account_number";

    public static final String my_status_show = GlobalSettings.packageName + ":id/my_status_show";

    public static final String setting_status = GlobalSettings.packageName + ":id/setting_status_item";


    public static String getTitle() {
        return title;
    }

    public static String getEdit_avatar() {
        return edit_avatar;
    }

    public static String getNickname() {
        return nickname;
    }

    public static String getEdit_nickname() {
        return edit_nickname;
    }

    public static String getAccount_number() {
        return account_number;
    }

    public static String getMy_status_show() {
        return my_status_show;
    }

    public static String getSetting_status() {
        return setting_status;
    }


}
