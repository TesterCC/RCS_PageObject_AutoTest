package com.rcstest.settings;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * GlobalSettings is a class for managing all global variables.
 * 
 * @author Li Yanxi
 * @version 1.0
 *
 */

public class GlobalSettings {
	//全局变量替换包名,其他类调用方法：ClassName.VariableName

	//log4j configuration file
	public static String log4jConfig = "E:\\my_codes\\RCSTest\\src\\main\\resources\\log4j.properties";

	//===Set Appium Parameter capabilities.setCapability=== use setter/getter is better
	public static final String packageName = "com.starhub.rcsstarhubstaging";
//	public static final String packageName_prod = "com.starhub.messageplus";
//	public static final String packageName_stg = "com.starhub.rcsstarhubstaging";
	
	public static String launchactivityName = ".login.LoginSlapshActivity";
	
	public static String waitactivityName = ".login.LoginSlapshActivity";

	public static String deviceName = "Test Device";
	
	//device udid in adb
	//apppium server # appium -U udid
	public static String deviceUdid = "93e2da8b";    //or "192.168.2.78:5555"
	public static String deviceUdid_IP = "192.168.2.78:5555";
	public static String deviceUdid_SamsungNote3 = "32041a4eb592c0bf";
	public static String deviceUdid_SamsungNote4White = "93e2da8b";
	public static String deviceUdid_SamsungNote4Black = "84b8c68c";
	public static String deviceUdid_SamsungTabPro = "4e5aedcd04d4c7ab"; //some different with smart phone
	public static String deviceUdid_HtcOneM8 = "HC44WWM01499";
	
	public static String platformName = "Android";
	
	public static String platformVersion = "5.0.1";
	
	public static String driverUrl = "http://127.0.0.1:4723/wd/hub";
	
	
	//===Test RCS App needed CONSTANT===
	public static String login_num = "94290439";  //the login account your search
//	static String login_num = "88880019";  //stage,the login account your search

	public static String other_num1 = "98805407";  //the person name your search
//	static String other_num1 = "88880041";  //stage,the person name your search

	public static String other_num2 = "98805408";  //the person name your search
//	static String other_num2 = "88880035";  //stage,the person name your search
	
	//组名根据时间生成
	//static不能包含变量-201503121233
	public static String group_title = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

	//上面的由来,输出固定时间格式作为GroupName
//	Date d = new Date();
//	DateFormat sdf7 = new SimpleDateFormat("yyyyMMddHHmm");
//	static String group_title = sdf7.format(d);
	

	//chat input and send message test text
	public static String inputbox_text = "send_message_test,today, www.globalroam.com, 98805407;justfortest@globalroam.com.X+";
	
	public static String maxmium_text = "a1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678z"; 


}
