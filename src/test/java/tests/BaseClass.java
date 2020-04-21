package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



/*
 * This is the Base class for all the future test cases
 * It loads all the environment parameters from the properties file
 * The proceeds to creating an appium driver for the testing
 * This class is to be inherited to all test case class in order to be able to execute the tests 
 * 
 * */



public class BaseClass {
	
	AppiumDriver<MobileElement> driver;

	private String deviceName;
	private String appPath;
	private String platformVersion;
	private String platformName;
	private String automationName;
	private String appPackage;
	private String appActivity;
	
	@BeforeMethod
	@Parameters({"properties"})
	public void setup(String properties) {
		
		
		//	Read all the setup parameters from the relevant .properties file
		
		loadProperties(properties);
		
		
		//	Once all the capabilities are set, a driver is created
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformName", platformName);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("automationName", automationName);
		cap.setCapability("app", System.getProperty("user.dir") + appPath);
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		
		
		try{
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	

	// Method to read the test parameters from the .properties file
	
	private void loadProperties(String config) {
		
		FileInputStream propertiesFIS;
		Properties properties = new Properties();
		String propertiesFilePath = String.format("src/test/resources/properties/%s.properties", config);
		
		try {
		  propertiesFIS = new FileInputStream(propertiesFilePath);
		  properties.load(propertiesFIS);
		
		  //	Read all the properties and save them in the local variables
		  
		  appPath = properties.getProperty("app");
		  platformVersion = properties.getProperty("platformVersion");
		  platformName = properties.getProperty("platformName");
		  deviceName = properties.getProperty("deviceName");
		  automationName = properties.getProperty("automationName");
		  appPackage = properties.getProperty("appPackage");
		  appActivity = properties.getProperty("appActivity");
		
		} catch (IOException e) {
		  System.out.println("Properties file is missing or invalid! Check path to file: " + propertiesFilePath);
		  System.exit(0);
		}
	    
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
