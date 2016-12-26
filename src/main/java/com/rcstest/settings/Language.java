package com.rcstest.settings;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wangjuan on 2016/2/25.
 * @Description:
 */
public class Language {
    private static final Logger logger = Logger.getLogger(Language.class);
    private static String areaLanguage;
    private static String SESSION_LANGUAGE_KEY = "sessionLanguage";
    private static String LANGUAGE_KEY = "language";
    private static String CHINESE_LANGUAGE_KEY = "zh";
    private static String ENGLISH_LANGUAGE_KEY = "en";

    public String getAreaLanguage() {
        return areaLanguage;
    }

    public void setAreaLanguage(String language) {
        areaLanguage = language;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //当前session的语言，暂时未做处理，以后可能加上用户选择语言。
        String language = request.getLocale().getLanguage();

        //如果不是中文则统一设置为英语
        if(this.ENGLISH_LANGUAGE_KEY.equalsIgnoreCase(language)){ //change to English
            language = "_en";
        }else{
            language = "_zh";
        }

        String sessionLanguage = (String) request.getAttribute(this.SESSION_LANGUAGE_KEY);
        String currentLanguage = sessionLanguage == null?language:sessionLanguage;

        //将语言类型存放request，页面显示不同语言
        request.setAttribute(this.LANGUAGE_KEY,language);
        request.getSession().setAttribute(this.SESSION_LANGUAGE_KEY,language);

        logger.info("requestLanguage :==>" + language);
        logger.info("currentLanguage :==>" + currentLanguage);
        return true;
    }

}
