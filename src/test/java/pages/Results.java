package pages;

import java.util.List;
import helpers.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Results {

	AndroidDriver<MobileElement> driver;
	
	
	/*
	 * Following are the declarations of the locators of the elements of the page 
	 * */
	
	String searchResults = "//android.view.View[@resource-id='search']";
	
	public Results(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Taps on a random result on the result page
	
	public String tapOnAResult() {
		
		MobileElement el = Util.elementXpath(searchResults, driver);
		List<MobileElement> results = Util.subElementsClassName("android.view.View", el);
		int rand = (int)(Math.random() * 4);
		rand = ((rand+1) * 9) - 2;
		rand  = 17;
		el = results.get(rand);
		String productName = el.getText();
		el.click();
		return productName;
		
	}
}
