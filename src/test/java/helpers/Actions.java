package helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


/*
 * This is a utility class which contains methods related to touch actions
 * For the purpose of this assignment only coordinates based swipe action is implemented
 * 
 * */


public class Actions {

	public static void swipe(int startx, int starty, int endx, int endy, AppiumDriver<MobileElement> driver ) {
		TouchAction action = new TouchAction(driver);
		action.press( PointOption.point(startx, starty) );
		action.moveTo( PointOption.point(endx, endy) );
		action.release();
		action.perform();
	}
}
