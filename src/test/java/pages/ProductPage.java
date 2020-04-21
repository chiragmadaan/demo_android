package pages;

import helpers.Actions;
import helpers.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage {

	AndroidDriver<MobileElement> driver;
	
	
	/*
	 * Following are the declarations of the locators of the elements of the page 
	 * */
	
	String buyButton = "buyNowCheckout";
	String addToCartButton = "//android.widget.Button[@resource-id='add-to-cart-button']";
	String productName = "//android.view.View[@resource-id='title']";
	String cart = "//android.widget.ImageView[@content-desc='Basket']";
	
	public ProductPage(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Returns the name of the product that is displayed 
	
	public String getProductName() {
		return Util.elementXpath(productName, driver).getText();
	}
	
	
	// Brings the Buy Now button and Add to Cart button into the view by swiping up
	
	public void adjustView() {
		Actions.swipe(200, 800, 200, 400, driver);
	}
	
	
	// Taps on the Buy Now button
	
	public void tapBuyButton() {		
		Util.elementID(buyButton, driver).click();;
	}
	
	
	// Tap on the Add to Cart button
	
	public void tapAddToCartButton() {
		Util.elementXpath(addToCartButton, driver).click();;
	}
	
	
	// Taps on the Basket icon to go to the Cart view
	
	public void goToCart() {
		Util.elementXpath(cart, driver).click();
	}
}
