package pages;

import helpers.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/*
 * This class if for the Signin page which is shown when the application is launched
 * 
 * */


public class SignInPage {

	AndroidDriver<MobileElement> driver;
	
	
	/*
	 * Following are the declarations of the locators of the elements of the page 
	 * */
	
	String signInButton = "com.amazon.mShop.android.shopping:id/sign_in_button";
	String skipSignInButton = "com.amazon.mShop.android.shopping:id/skip_sign_in_button";
	String emailTextField = "//android.widget.EditText[@resource-id='ap_email_login']";
	String passwordTextField = "//android.widget.EditText[@resource-id='ap_password']";
	String continueButton = "//android.widget.Button[@resource-id='continue']";
	String signInSubmitButton = "//android.widget.Button[@resource-id='signInSubmit']";
	
	public SignInPage(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Taps on the Sign-In button on the first view
	
	public void tapSignInButton() {
		Util.elementID(signInButton, driver).click();
	}
	
	
	// Taps on the skip Sign-In button on the first view
	
	public void tapSkipSignInButton() {
		Util.elementID(skipSignInButton, driver).click();
	}
	
	
	// Enter the email ID and the password in the relevant fields
	
	public void enterLoginDetails(String email, String password) {

		Util.elementXpath(emailTextField, driver).sendKeys(email);
		tapContinueButton();
		Util.elementXpath(passwordTextField, driver).sendKeys(password);
	}
	
	
	// Tap on the Continue button to go to the password view
	
	public void tapContinueButton() {
		Util.elementXpath(continueButton, driver).click();
	}
	
	
	// Tap on the Submit button to finalize the login process
	
	public void tapSubmitButton() {
		Util.elementXpath(signInButton, driver).click();
	}
}
