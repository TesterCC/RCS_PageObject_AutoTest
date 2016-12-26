package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;


/**
 * Created by Li Yanxi on 2016/3/31.
 */
public class ChatsActivityElement {

    //in OTP Activity - After login successfully
    public static final String check_img = GlobalSettings.packageName + ":id/img";

    public static final String search_btn =  GlobalSettings.packageName + ":id/search_btn";

    public static final String title = GlobalSettings.packageName + ":id/conversation_type";

    public static final String add_group_conversation = GlobalSettings.packageName + ":id/add_group_conversation";

    public static final String add_conversation = GlobalSettings.packageName + ":id/add_conversation";

    public static final String conversation_search_back = GlobalSettings.packageName + ":id/conversaiton_search_back";

    public static final String compose_btn = GlobalSettings.packageName + ":id/compose_btn";


    public static String getCheck_img() {
        return check_img;
    }

    public static String getSearch_btn() {
        return search_btn;
    }

    public static String getTitle() {
        return title;
    }

    public static String getAdd_group_conversation() {
        return add_group_conversation;
    }

    public static String getAdd_conversation() {
        return add_conversation;
    }

    public static String getConversation_search_back() {
        return conversation_search_back;
    }

    public static String getCompose_btn() {
        return compose_btn;
    }
}
