package com.rcstest.customaction;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

//test ,basic of CustomAction, suggest transfer to InitialDriver


public class EncapsulationAction{
	public static AndroidDriver<WebElement> driver; //which different from CustomAction,add driver
	
	   /*======Encapsulation Some Actions==========*/	
	//just encapusulate some action	
	//longpress on element

	/**
	 *
	 * @author
	 *
	 * @param by
	 * @param duration
	 *
	 * */
	public static void longPress(By by,int duration){
		try{
			WebElement element=driver.findElement(by);
			TouchAction ta = new TouchAction(driver);
			ta.longPress(element,duration).release().perform();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	//longpress btn by coordinate
	public static void longPress(int x,int y,int time){
		try{
			TouchAction ta = new TouchAction(driver);
			ta.longPress(x,y,time).release().perform();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getPageSource(){
		return driver.getPageSource();
	}
	
	public static void wait(int timeout){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	
	
	//Tap Element
	public static void tapel(WebElement element){
		try {
			TouchAction ta = new TouchAction(driver);
			ta.tap(element);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//Tap Coordinate
	public static void tapel(int x,int y){
		try {
			TouchAction ta = new TouchAction(driver);
			ta.tap(x,y);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/*-----Swipe to direction-----*/
	//获取应用占屏幕大小-key
	public int[] appScreen(){
		int width=driver.manage().window().getSize().getWidth();//一般是手机屏宽
		int heightScreen=driver.manage().window().getSize().getHeight();//上面有导航栏，所以不能直接取高
		int[] appWidthAndHeight={width,heightScreen};//存入数组,[0][1]
		return appWidthAndHeight;
	}
	

	//Swipe to left
	public void swipeToLeft(int duration){
		int startx=this.appScreen()[0]*4/5;
		int endx=this.appScreen()[0]*1/5;
		int y=this.appScreen()[1]*1/2;
		try {
			driver.swipe(startx,y, endx, y, duration);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//Swipe to right
	public void swipeToRight(int duration){
		int startx=this.appScreen()[0]*1/5;
		int endx=this.appScreen()[0]*4/5;
		int y=this.appScreen()[1]*1/2;
		try {
			driver.swipe(startx,y, endx, y, duration);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//Swipe to up
	public void swipeToUp(int duration){
		int startx=this.appScreen()[1]*4/5;
		int endx=this.appScreen()[1]*1/5;
		int y=this.appScreen()[0]*1/2;
		try {
			driver.swipe(startx,y, endx, y, duration);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	//Swipe to down
	public void swipeToDown(int duration){
		int startx=this.appScreen()[1]*1/5;
		int endx=this.appScreen()[1]*4/5;
		int y=this.appScreen()[0]*1/2;
		try {
			driver.swipe(startx,y, endx, y, duration);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//通过参数实现各方向滑动
//	public void swipe(String direction,int duration){
//		switch(direction){
//		case "Up":
//			this.swipeToUp(duration);
//			break;
//		case "Down":
//			this.swipeToDown(duration);
//			break;
//		case "Left":
//			this.swipeToLeft(duration);
//			break;
//		case "Right":
//			this.swipeToRight(duration);
//			break;
//		default:
//			break;
//		}
//	}
	
	
	//封装Swipe方法，实现在某元素上滑动
//	public static void swipeOnElement(WebElement element,String direction,int duration){
//		//x,y分别为元素的起始坐标点
//		int x=element.getLocation().getX();//获取该元素起始x值
//		int y=element.getLocation().getY();//获取该元素起始y值
//		int elementWidth=element.getSize().getWidth();
//		int elementHeight=element.getSize().getHeight();
//		switch(direction){
//		case "Up":
//			int startx = x + elementWidth/2;
//			int starty = y + elementHeight*4/5;
//			int endy=y + elementHeight*1/5;
//			driver.swipe(startx, starty, startx, endy, duration);
//			break;
//		case "Down":
//			startx = x + elementWidth/2;
//			starty = y + elementHeight*1/5;
//			endy=y + elementHeight*4/5;
//			driver.swipe(startx, starty, startx, endy, duration);
//			break;
//		case "Light":
//			starty = x + elementWidth/2;
//			startx = y + elementHeight*4/5;
//			int endx = y + elementWidth*1/5;
//			driver.swipe(startx, starty, startx, starty, duration);
//			break;
//		case "Right":
//			starty = x + elementHeight/2;
//			startx = y + elementWidth*1/5;
//			endx = y + elementWidth*4/5;
//			driver.swipe(startx, starty, endx, starty, duration);
//			break;
//		default:
//			break;
//		}
//	}
	
	//在某方向上滑动直至期望的元素出现
//	public void swipeUtilElementAppear(By by,String direction,int duration){
//		boolean flag = true;
//		//死循环，可以加for语句找几次后结束
//		while(flag){
//			try {
//				driver.findElement(by);
//			} catch (Exception e) {
//				// TODO: handle exception
//				this.swipe(direction, duration);
//			}
//		}
//	}

	
	/*封装检查元素是否存在*/
	//判断元素是否存在
	public static boolean isElementExist(By by){
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	
	//在指定超时时间内元素是否存在，如果存在则立即返回结果-report error
//	public boolean isElementExist(By by, int timeout){
//		try {
////			super.findElement(by);
//			new WebDriverWait(driver.timeout).until(ExpectedConditions.presenceOfElementLocated(by));
//			return true;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return false;
//		}
//	}
	
	
	//just for reference
//	@Override
//	public void tap(int fingers, WebElement element,int duration){
//		MultiTouchAction multiTouch = new MultiTouchAction(this);
//		
//		for (int i = 0; i< fingers; i++){
//			multiTouch.add(createTap(element, duration));
//		}
//		multiTouch.perform();
//	}
		
	
	
}
