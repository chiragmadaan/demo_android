package pages;

import java.util.List;

import helpers.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CartPage {

	AndroidDriver<MobileElement> driver;
	
	
	/*
	 * Following are the declarations of the locators of the elements of the page 
	 * */
	
	String checkout = "//android.view.View[@resource-id='sc-mini-buy-box']";
	String cart = "//android.view.View[@resource-id='activeCartViewForm']";
	String deleteButton = "//android.view.View[@resource-id='a-autoid-2']";
	
	
	public CartPage(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Returns the name of the item that is present in the cart
	
	public String getCartItem() {
		MobileElement el = Util.elementXpath(cart, driver);
		List<MobileElement> els = Util.subElementsClassName("android.view.View", el);
		return els.get(3).getText();
	}
	
	// Removes the item from the cart
	
	public void deleteItem() {
		MobileElement el = Util.elementXpath(deleteButton, driver);
		Util.subElementClassName("android.widget.Button", el).click();
	}
	
	
	// Return true  if the Checkout button is displayed on the view, else returns false
	
	public boolean isCheckoutButtonPresent() {
		try{
			Util.elementXpath(checkout, driver);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
