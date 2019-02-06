/**
 * 
 */
package com.qachallenge;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.seleniumframework.selenium.SeleniumDriver;

/**
 * @author kiran
 *
 */
public class DashboardDriver {
	static Logger log = Logger.getLogger(DashboardDriver.class);
	public static SeleniumDriver driver;

	
	
	
	@BeforeSuite
	public static void beforeSuite() {
		PropertyConfigurator.configure(System.getProperty("user.dir") + System.getProperty("file.separator") + "properties" + System.getProperty("file.separator") + "log4j.properties");

		log.info("-------------------------------------------- STARTED --------------------------------------------");

		try {
			SeleniumDriver.getTestAutomationProperties(System.getProperty("user.dir") + System.getProperty("file.separator") + "config", "Automation");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("------------------------------------------- COMPLETED -------------------------------------------");
	}
	

	@BeforeTest
	public static void initializeSetup() {
		log.info("Before Test is executing...");
		driver = new SeleniumDriver();
		driver.initializeDriver();	
		driver.openUrl(SeleniumDriver.getProperty("URL"));	
		log.info("URL is opened." + driver.printLineSeparatedMessage("URL", SeleniumDriver.getProperty("URL")));
		log.info("Before Test is executed.");
	}
	
	@AfterTest
	public static void postTearDown() {
		log.info("After Test is executing...");
		driver.closeAllBrowser();
		log.info("After Test is executed.");
	}
}