package com.rcstest.element;

import com.rcstest.settings.GlobalSettings;

/**
 * Class in element is for managing element in page.
 * Created by Li Yanxi on 2016/3/28.
 */
public class LoginActivityElement {


    public static final String welcome_label = GlobalSettings.packageName + ":id/welcome_label";
    public static final String choose_countrycode = GlobalSettings.packageName + ":id/choose_country_code_info";
    public static final String enter_number = GlobalSettings.packageName + ":id/enter_number";
    public static final String accept_checkbox = GlobalSettings.packageName + ":id/accept_checkbox";
    public static final String activate_btn = GlobalSettings.packageName + ":id/activate_btn";
    public static final String help_btn = GlobalSettings.packageName + ":id/help";


    public static final String enter_number_hinttext = GlobalSettings.packageName + ":id/enter_number";
    public static final String terms_conditions = GlobalSettings.packageName + ":id/terms_condition";



    public static String getChoose_countrycode() {
        return choose_countrycode;
    }

    public static String getEnter_number() {
        return enter_number;
    }

    public static String getAccept_checkbox() {
        return accept_checkbox;
    }

    public static String getActivate_btn() {
        return activate_btn;
    }

    public static String getHelp_btn() {
        return help_btn;
    }

    public static String getWelcome_label() {
        return welcome_label;
    }

    public static String getEnter_number_hinttext() {
        return enter_number_hinttext;
    }

    public static String getTerms_condition() {
        return terms_conditions;
    }




}
