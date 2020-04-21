package helpers;

import java.util.List;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


/*
 * This is a utility class which will be used for utility functions
 * like getting element or a list of elements based of different type of 
 * locator strategies
 * 
 * element(): returns the first element that matches the provided MobileBy locator 
 * elements(): returns the list of elements that match the provided MobileBy locator
 * elementID(): returns the first element that matches the provided ID 
 * elementsID(): returns the list of elements that match the provided ID
 * elementXpath(): returns the first element that matches the provided Xpath 
 * elementsXpath(): returns the list of elements that match the provided Xpath
 * elementClassName(): returns the first element that matches the provided Class Name 
 * elementsClassName(): returns the list of elements that match the provided Class Name
 * subElementClassName(): returns the first element that matches the provided Class Name inside another element 
 * subElementsClassName(): returns the list of elements that match the provided Class Name inside another element
 * 
 * */


public class Util {

	public static MobileElement element( MobileBy locator, AppiumDriver<MobileElement> driver ) {
		return driver.findElement(locator);
	}
	
	public static List<MobileElement> elements( MobileBy locator, AppiumDriver<MobileElement> driver ){
		return driver.findElements(locator);
	}
	
	public static MobileElement elementID( String locator, AppiumDriver<MobileElement> driver ) {
		return driver.findElement(By.id(locator));
	}
	
	public static List<MobileElement> elementsID( String locator, AppiumDriver<MobileElement> driver ){
		return driver.findElements(By.id(locator));
	}
	
	public static MobileElement elementXpath( String locator, AppiumDriver<MobileElement> driver ) {
		return driver.findElement(By.xpath(locator));
	}
	
	public static List<MobileElement> elementsXpath( String locator, AppiumDriver<MobileElement> driver ){
		return driver.findElements(By.xpath(locator));
	}
	
	public static MobileElement elementClassName( String locator, AppiumDriver<MobileElement> driver ) {
		return driver.findElement(By.className(locator));
	}
	
	public static List<MobileElement> elementsClassName( String locator, AppiumDriver<MobileElement> driver ){
		return driver.findElements(By.className(locator));
	}
	
	public static List<MobileElement> subElementsClassName( String locator, MobileElement el ){
		return el.findElements(By.className(locator));
	}
	
	public static MobileElement subElementClassName( String locator, MobileElement el ){
		return el.findElement(By.className(locator));
	}
	
}
