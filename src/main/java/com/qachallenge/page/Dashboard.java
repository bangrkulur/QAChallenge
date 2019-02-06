/**
 * 
 */
package com.qachallenge.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import com.qachallenge.DashboardDriver;
import com.seleniumframework.selenium.SeleniumDriver;

/**
 * @author kiran
 *
 */
public class Dashboard extends DashboardDriver{
	static Logger log = Logger.getLogger(Dashboard.class);
	private static final By.ByXPath INPUT_SEARCH = (ByXPath) By.xpath("//input[@name='searchFilter']");
	private static final By.ByXPath CONTROL_HEADING = (ByXPath) By.xpath("//span[text()='Controls']");
	private static final By.ByXPath CONTROL_SUBHEADING = (ByXPath) By.xpath("//span[text()='Filter/Export']");
	private static final By.ByXPath STATISTICS_HEADING = (ByXPath) By.xpath("//span[text()='Statistics']");
	private static final By.ByXPath STATISTICS_SUBHEADING = (ByXPath) By.xpath("//span[text()='high-level/summations']");
	private static final String STAT_VARIABLE = "//p[@class='listItems ng-binding ng-scope' and contains(text(),'" + SeleniumDriver.XPATH_PARAM_0 + "')]";
	private static final String STAT_RESULT_DIVISON = "//div[@class='projectFields']/span[contains(text(),'" + SeleniumDriver.XPATH_PARAM_0 + "')]";
	private static final String STAT_RESULT_RECORD = "//div[@class='projectFields layout-row']/span[contains(text(),'" + SeleniumDriver.XPATH_PARAM_0 + "')]";
	private static final By.ByXPath RESULT_SET = (ByXPath) By.xpath("//div[@class='md-primary md-subheader']");

	public static void isSearchDisplayed() {
		if (driver.isElementPresentNDisplayed(INPUT_SEARCH, "Search")) 
			driver.passTest("Search is displayed");
		else
			driver.failTest("Search is NOT displayed");
	}

	public static void isStatisticsDisplayed() {
		if ((driver.isElementPresentNDisplayed(STATISTICS_HEADING, "Statistics Title")) && (driver.isElementPresentNDisplayed(STATISTICS_SUBHEADING, "Statistics Sub-Heading")))
			driver.passTest("Statistics block is displayed");
		else
			driver.failTest("Statistics block is NOT displayed");
	}

	public static void isControlDisplayed() {
		if ((driver.isElementPresentNDisplayed(CONTROL_HEADING, "Control Title")) && (driver.isElementPresentNDisplayed(CONTROL_SUBHEADING, "Control Sub-Heading")))
			driver.passTest("Control block is displayed");
		else
			driver.failTest("Control block is NOT displayed");
	}

	public static void searchRecordsDivison(String inputString) {
		if (Dashboard.search(inputString))
		{
			int count = 0;
			String label = driver.findElement(driver.getByXpath(STAT_VARIABLE, inputString), inputString).getText();
			count = Integer.parseInt(label.split(":")[1].trim());
			log.info("Count on the Statistics section -- " + count );
			//This is to get the count from the Search
			int result_count = driver.getDriver().findElements(driver.getByXpath(STAT_RESULT_DIVISON, inputString)).size();
			log.info("Count based on the Search -- " + result_count);
			//Compare
			if (count == result_count)
				driver.passTest("Test Pass");
			else
				driver.failTest("Test Fail");
		}
	}

	public static void searchRecordsStatus(String inputString) {
		if (Dashboard.search(inputString))
		{
			int count = 0;
			String label = driver.findElement(driver.getByXpath(STAT_VARIABLE, inputString), inputString).getText();
			count = Integer.parseInt(label.split(":")[1].trim());
			log.info("Count on the Record Status section -- " + count );
			//This is to get the count from the Search
			int result_count = driver.getDriver().findElements(driver.getByXpath(STAT_RESULT_RECORD, inputString)).size();
			log.info( "Count based on the Search -- " + result_count);
			//Compare
			if (count == result_count)
				driver.passTest("Test Pass");
			else
				driver.failTest("Test Fail");
		}
	}

	public static void searchbyName(String inputString) {

		if (Dashboard.search(inputString))
		{
			int result_count = driver.getDriver().findElements(driver.getByXpath(STAT_RESULT_RECORD, inputString)).size();
			log.info("Count based on the Search -- " + result_count);
		}
	}

	public static void searchbyDate(String inputString) {
		if (Dashboard.search(inputString))
		{
			int result_count = driver.getDriver().findElements(driver.getByXpath(STAT_RESULT_DIVISON, inputString)).size();
			log.info("Count based on the Search -- " + result_count);
		}
	}

	private static boolean search(String inputString) {
		driver.findElement(INPUT_SEARCH, "Search").clear();
		driver.findElement(INPUT_SEARCH, "Search").click();
		driver.findElement(INPUT_SEARCH, "Search").sendKeys(inputString);
		//This is to get the count from the Search
		int mainresult = driver.getDriver().findElements(RESULT_SET).size();
		if (mainresult > 0)
		{
			return true;
		}
		else
		{
			log.info("Not a valid input");
			return false;
		}
	}



}
