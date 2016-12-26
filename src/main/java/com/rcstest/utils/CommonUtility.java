package com.rcstest.utils;

import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * @Author: wangjuan on 2016/2/22.
 * @Description:
 */
public class CommonUtility {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(CommonUtility.class);
    private static final String EMAIL_PATTERN = "^((([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+(\\.([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?$";
    private static final String NUMBER_PATTERN = "^([0-9]+)$";
    private static GsonBuilder builder = new GsonBuilder();



    /**
     * @param str
     * @return
     */
    public static boolean isNonEmpty(String str) {
        boolean result = false;
        if(str != null && !"".trim().equals(str)) {
            result = true;
        }
        return result;
    }



    /**
     * Get property from properties file. If properties name contains _cn, do code transfer.
     * wangjuan
     * @param key, properties_name
     * @return
     */
    public static String getProperty(String key, String properties_name) {
        try {
            Properties prop = new Properties();
            InputStream in = CommonUtility.class.getClassLoader()
                    .getResourceAsStream(properties_name);
            prop.load(in);
            if(properties_name.contains("_cn")){
                return new String(prop.getProperty(key).getBytes("ISO-8859-1"),"gbk");
            }
            return prop.getProperty(key).trim();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static Properties getPropertyFile(String fileName) {
        try {
            Properties prop = new Properties();
            InputStream in = CommonUtility.class.getClassLoader()
                    .getResourceAsStream(fileName);
            prop.load(in);
            return prop;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }



    /**
     * convert GMT
     *
     * @param
     * @return
     * @throws ParseException
     */
    public static long convertCalendarToTimestamp(String calendar,
                                                  TimeZone timezone) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(timezone);
        // log.info("timezone:"+timezone.getID());
        long time = format.parse(calendar).getTime();
        return time;
    }

    public static String convertCurrentTimestampToCalendar(TimeZone timezone) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            format.setTimeZone(timezone);
            Date date = new Date();
            String calendarStr = format.format(date);
            return calendarStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param str
     * @return
     */
    public static String removeBlank(String str) {
        str = deleteBlock(str, "");
        return str;
    }

    public static String removeBlank(String str,String replace) {
        str = deleteBlock(str, replace);
        return str;
    }

    private static String deleteBlock(String str, String replace) {
        StringBuffer sb = new StringBuffer();
        if (isNonEmpty(str)) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char s = str.charAt(i);
                if (0 == s || 32 == s) {
                    if(isNonEmpty(replace)) sb.append(replace);
                    continue;
                } else {
                    sb.append(s);
                }
            }
            str = sb.toString();
        }
        return str;
    }

    public static String formatTime(String seconds) {
        int time = Integer.parseInt(seconds);
        DecimalFormat df = new DecimalFormat("00");
        int sec = time%60;
        int min = (time%3600)/60;
        int hour = time/3600;

        String sec_str = df.format(sec);
        String min_str = df.format(min);
        String hour_str = df.format(hour);

        String time_str = "";
        if(hour == 0) {
            if(min == 0) {
                time_str = sec_str +" secs";
            } else {
                time_str = min_str + " mins " + sec_str +" secs";
            }
        } else {
            time_str = hour_str + " hous " + min_str + " mins " + sec_str +" secs";
        }
        //01 hous 00 mins 00 secs
        return time_str;
    }


    public static String getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        return year;
    }
    public static String getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        return month;
    }
    public static String getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        return day;
    }
    public static String getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        return hour;
    }
    public static String getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        return minute;
    }
    public static String getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String second = String.valueOf(calendar.get(Calendar.SECOND));
        return second;
    }

    public static boolean isDateFormate(String timeStr) {
        boolean result = true;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-DD-mm");
        try {
            df.parse(timeStr);
        } catch (ParseException e) {
            result = false;
            logger.error(timeStr + "The string format is yyyy-MM-dd");
        }
        return result;
    }

    public static boolean isMobileNumber(String mobileNo) {
        boolean result = false;
        if (isNonEmpty(mobileNo)) {
            String regex = "^(\\+)*([0-9])+$";
            result = Pattern.compile(regex).matcher(mobileNo).matches();
        }
        return result;
    }

    public static boolean isNumber(String number) {
        Pattern numberPattern = Pattern.compile(NUMBER_PATTERN);
        if (isNonEmpty(number) && numberPattern.matcher(number).matches()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isEmail(String email) {
        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
        if (isNonEmpty(email) && emailPattern.matcher(email).matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param date
     * @return
     */
    public static String formateDate(Date date) {
        return formateDate(date,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param date
     * @param formate
     * @return
     */
    public static String formateDate(Date date,String formate) {
        SimpleDateFormat format = new SimpleDateFormat(formate);
        return format.format(date);
    }

    /**
     * @param
     * @return
     */
    public static Date parseDate(String time) {
        return parseDate(time,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param
     * @param formate
     * @return
     */
    public static Date parseDate(String time,String formate) {
        SimpleDateFormat format = new SimpleDateFormat(formate);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }



}

