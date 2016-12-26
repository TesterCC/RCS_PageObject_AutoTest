package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Created by Yanxi on 2016/4/5.
 */
public class SelectContactActivityElement {

    //title
    public static final String title = GlobalSettings.packageName + ":id/title";

    //back button
    public static final String back_btn = GlobalSettings.packageName + ":id/back_button";

    //search bar
    public static final String search_edittext = GlobalSettings.packageName + ":id/contact_list_auto";

    //Message+ list
    public static final String rcs_contacts = GlobalSettings.packageName + ":id/rcsContacts";

    //all list
    public static final String all_contacts = GlobalSettings.packageName + ":id/allContacts";

    //search result
    public static final String search_result = GlobalSettings.packageName + ":id/cell_name";

    //list view in BaseActivityElement


    public static String getTitle() {
        return title;
    }

    public static String getBack_btn() {
        return back_btn;
    }

    public static String getSearch_edittext() {
        return search_edittext;
    }

    public static String getRcs_contacts() {
        return rcs_contacts;
    }

    public static String getAll_contacts() {
        return all_contacts;
    }

}
