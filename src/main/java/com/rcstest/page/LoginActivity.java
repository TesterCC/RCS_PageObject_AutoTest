package com.rcstest.page;

import com.rcstest.customaction.CustomAction;
import com.rcstest.driver.InitialDriver;
import com.rcstest.element.LoginActivityElement;
import com.rcstest.settings.GlobalSettings;
import com.rcstest.settings.Language;
import com.rcstest.utils.CommonUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 *
 * Class in com.rcs.modules function: Manage elements in corresponding Activity.
 *
 * LoginActivity is a class for managing LoginActivity elements and method.
 *
 * @author Yanxi
 * @version 1.0
 *
 *
 */
public class LoginActivity extends BaseActivity{

	private final static Logger logger  =  Logger.getLogger(LoginActivity.class);
	private static String propertyFile = "elements_en.properties";
	private AndroidDriver<WebElement> driver;


	public LoginActivity(AndroidDriver<WebElement> driver) {
		super(driver); //extends from supper class
	}

	public void PageElementsCheck(AndroidDriver<WebElement> driver) throws Exception {

		WebElement welcome_label =  null;
		WebElement choose_countrycode = null;
		WebElement enter_number = null;
		WebElement enter_number_hinttext = null;
		WebElement accept_checkbox = null;
		WebElement activate_btn = null;
		WebElement terms_condition = null;
		WebElement help_btn = null;

		try {
			welcome_label = driver.findElementById(LoginActivityElement.getWelcome_label());
			choose_countrycode = driver.findElementById(LoginActivityElement.getChoose_countrycode());
			enter_number = driver.findElementById(LoginActivityElement.getEnter_number());
			enter_number_hinttext = driver.findElementById(LoginActivityElement.getEnter_number_hinttext());
			accept_checkbox = driver.findElementById(LoginActivityElement.getAccept_checkbox());
			activate_btn = driver.findElementById(LoginActivityElement.getActivate_btn());
			terms_condition = driver.findElementById(LoginActivityElement.getTerms_condition());
			help_btn = driver.findElementById(LoginActivityElement.getHelp_btn());
			logger.info("Find All Elements.");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can't find Element."+"\n"+e.getMessage());
		}
	}


	//Link to Element
//Use Page Object Model to locate element.
	@AndroidFindBy(id = LoginActivityElement.welcome_label)
	public WebElement welcome_label;

	@AndroidFindBy(id = LoginActivityElement.choose_countrycode)  //value must to constant
	public WebElement choose_countrycode;

	@AndroidFindBy(id = LoginActivityElement.enter_number)
	public WebElement enter_number;

	@AndroidFindBy(id = LoginActivityElement.enter_number_hinttext)
	public WebElement enter_number_hinttext;

	@AndroidFindBy(id = LoginActivityElement.accept_checkbox)
	public WebElement accept_checkbox;

	@AndroidFindBy(id = LoginActivityElement.activate_btn)
	public WebElement activate_btn;

	@AndroidFindBy(id = LoginActivityElement.terms_conditions)
	public WebElement terms_conditions;

	@AndroidFindBy(id = LoginActivityElement.help_btn)
	public WebElement help_btn;




//Encapsulate Method
	
	//Basic login steps
	public void loginApp(AndroidDriver<WebElement> driver,String account) throws Exception{
		enter_number.sendKeys(account);
		driver.hideKeyboard();
		checkActivateBtn();
		accept_checkbox.click();
		
		if(!activate_btn.isEnabled()){
			InitialDriver.killApp();
			logger.error("Activate Service is disable.");
		}else{
			logger.info("Activate Service is enable. Click it now.");
			activate_btn.click();
		}
		
	}


	//Jump to Help

	public void toHelpAty() throws InterruptedException {
		help_btn.click();
		Thread.sleep(1000);
		InitialDriver.currentAty();
		InitialDriver.checkAty("Help");

	}

	//Jump to Terms & Conditions



	//Check Activate Button is enable or disable.
	public void checkActivateBtn(){

		Boolean b = activate_btn.isEnabled();
		if (b==true){
			logger.info("Activate Service is enable.");
		}else{
			logger.info("Activate Service is disable.");
		}
	}

	//web method - not modified,ignore
	public void SwitchLanguage(Language language){
		if (language.getAreaLanguage().equalsIgnoreCase("en")){
			propertyFile = "elements_en.properties";
		}else {
			propertyFile = "elements_ch.properties";
		}
	}


	//web method - not modified,ignore
	public void chkeckLoginActivity(AndroidDriver<WebElement> driver){
//		String URL = CommonUtility.getProperty("FAQ_PAGE_URL", propertyFile);

		String title = CommonUtility.getProperty("WElCOME_LABEL", propertyFile);
		logger.debug("Property file : " + propertyFile);
		logger.debug("WElCOME_LABEL is : " + title);
		if (!welcome_label.getText().equals(title)) {
			logger.error("Jump to error Activity. WElCOME_LABEL : " + driver.getTitle());
		}
	}


	public void toTermsConditions() throws InterruptedException {
		terms_conditions.click();
		Thread.sleep(1000);
		InitialDriver.currentAty();
		InitialDriver.checkAty("Terms & Conditions");
	}

	public void toChooseCountrycode() throws InterruptedException{
		choose_countrycode.click();
		Thread.sleep(1000);
		InitialDriver.currentAty();
		InitialDriver.checkAty("Country Code");
	}


	public void inputAccount(){
		String str = enter_number_hinttext.getText();
		if(str == "Enter your phone number"){
			enter_number.click();
			enter_number.sendKeys(GlobalSettings.login_num);
		}else{
			enter_number.clear();
			enter_number.sendKeys(GlobalSettings.login_num);
		}
		logger.info("Finish input account.");
	}


	public void clickAcceptCheckbox(){
		accept_checkbox.click();
		logger.info("Click accept checkbox button.");
	}

	public void clicktoLogin() throws InterruptedException {
		activate_btn.click();
		logger.info("Click Activate Service button,to OTP Activity.");
		Thread.sleep(500);
	}
}





//public boolean VerifyResult(String result) {
//if (txtResult.getText().equals(result))
//	return true;
//else
//	return false;
//}
