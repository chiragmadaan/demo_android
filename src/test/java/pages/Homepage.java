package pages;

import helpers.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Homepage {

	AndroidDriver<MobileElement> driver;
	
	
	/*
	 * Following are the declarations of the locators of the elements of the page 
	 * */
	
	String searchBar = "com.amazon.mShop.android.shopping:id/rs_search_src_text";
	
	public Homepage(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Enter the search text into the search bar and hit enter
	
	public void enterSearchText(String searchText) {
		Util.elementID(searchBar, driver).click();
		Util.elementID(searchBar, driver).sendKeys(searchText);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
}
