package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Li Yanxi on 2016/4/1.
 */
public class ContactsActivityElement {

    //title
    public static final String title = GlobalSettings.packageName + ":id/title";

    //list view in BaseActivityElement

    //top-left search button
    public static final String search_btn = GlobalSettings.packageName + ":id/search_btn";

    //top-right add contact use system
    public static final String new_contact = GlobalSettings.packageName + ":id/newContact";

    //Message+ list
    public static final String rcs_contacts = GlobalSettings.packageName + ":id/rcsContacts";

    //All list
    public static final String all_contacts = GlobalSettings.packageName + ":id/allContacts";

    //After search -- back button
    public static final String back_btn = GlobalSettings.packageName + ":id/back_button";

    public static String getBack_btn() {
        return back_btn;
    }

    public static String getTitle() {
        return title;
    }

    public static String getSearch_btn() {
        return search_btn;
    }

    public static String getNew_contact() {
        return new_contact;
    }

    public static String getRcs_contacts() {
        return rcs_contacts;
    }

    public static String getAll_contacts() {
        return all_contacts;
    }
}
